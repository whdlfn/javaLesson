package project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc.day1.OracleConnectionUtil;
import project.vo.BuyVo;
import project.vo.CustomerBuyVo;

public class TblBuyDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // executeUpdate 메소드는insert, update, delete가 정상 실행(반영된 행이 있으면)되면 1을 리턴,
    // 특히 update랑 delete는 조건에 맞는 행이 없어서 반영된 행이 없으면 0을 리턴
    // 구매
    public int insert(BuyVo vo) {
        String sql = "insert into tbl_buy values (buy_pk_sql.nextval,?,?,?, ,to_date)\n";
        int result = 0;

        try (
                Connection conn = OracleConnectionUtil.getConnection(); // 1) 서버와의 연결
                PreparedStatement pstmt = conn.prepareStatement(sql)) { // 2) 연결된 서버로 실행할 sql 정달. 서버가 컴파일
            pstmt.setInt(1, vo.getBuy_idx());
            pstmt.setString(2, vo.getCustomid());
            pstmt.setString(3, vo.getPcode());
            pstmt.setInt(4, vo.getQuantity());

            result = pstmt.executeUpdate(); // 리턴값 int 는 반영된 행의 개수를 리턴 // 3) 연결된 서버에 실행 요청
        } catch (SQLException e) {
            // customid와 pcode는 참조테이블에 존재하는 값이 아니면 무결성 위반 오류
            System.out.println("구매하기 실행 예외 발생 : " + e.getMessage());
        }
        return result;
    }

    // 구매 삭제
    public int delete(int buy_idx) {
        String sql = "delete from tbl_buy where buy_idx = ?";
        int result = 0;
        try (
                Connection conn = OracleConnectionUtil.getConnection(); // 1) 서버와의 연결
                PreparedStatement pstmt = conn.prepareStatement(sql)) { // 2) 연결된 서버로 실행할 sql 정달. 서버가 컴파일
            pstmt.setInt(1, buy_idx);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {

            // buy_idx컬럼에 없는 값이면 오류는 아니고 update반영된 행의 개수
            System.out.println("구매 취소 실행 예외 발생 : " + e.getMessage());
        }
        return result;

    }

    // 구매수량 수정 - pk는 행을 식별함. 특정 행을 수정하려면 where는 buy_idx(pk)
    public int modify(Map<String, Integer> arg) { // 인자를 map으로 바꿔봄
        String sql = "update tbl_buy set quantity = ?  where buy_idx = ?";
        int result = 0;

        try (
                Connection conn = OracleConnectionUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 할일 2 : 매개변수 바인딩(매개변수 타입에 맞는 메소드를 실행합시다)
            pstmt.setInt(1, arg.get("quantity"));
            pstmt.setInt(2, arg.get("buy_idx"));
            result = pstmt.executeUpdate(); // 실행
        } catch (SQLException e) {
            // buy_idx컬럼에 없는 값이면 오류는 아니고 update반영된 행의 개수
            System.out.println("구매 수정 예외 발생 : " + e.getMessage());
        }
        return result;

    }

    // mypage 기능의 메소드
    public List<CustomerBuyVo> selectCustomerBuyList(String costumerId) {
        List<CustomerBuyVo> list = new ArrayList<>();
        String sql = "SELECT BUY_IDX, TB.PCODE, PNAME,PRICE,QUANTITY ,BUY_DATE \r\n" +
                "FROM TBL_BUY tb \r\n" +
                "JOIN TBL_PRODUCT tp \r\n" +
                "ON TB.PCODE = TP.PCODE \r\n" +
                "WHERE TB.CUSTOMID =? \r\n" +
                "ORDER by BUY_DATE desc";
        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql);) {
            pstmt.setString(1, costumerId);
            ResultSet rs = pstmt.executeQuery();
            // pstmt.executeQuery();//executeUpdate() write용 executeQuery() read용- 잘못됨
            while (rs.next()) {
                list.add(new CustomerBuyVo(rs.getInt("BUY_IDX"),
                        rs.getString("PCODE"),
                        rs.getString("PNAME"),
                        rs.getInt("PRICE"),
                        rs.getInt("QUANTITY"),
                        rs.getTimestamp("BUY_DATE")));
            }
        } catch (SQLException e) {
            System.out.println("고객별 구매내역 실행 예외 발생 : " + e.getMessage());
        }
        return list;
    }

    // 장바구니 모두 구매
    // batch(배치) 는 일괄처리 : 실행할 insert, update, delete등의 데이터 저장 DML을 여러개 모아 두었다가 한번에
    // 실행시킴
    // 트랜잭션 : 특정 요구사항에 대한 하나의 기능을 실행할 여러 SQL명령들로 구성된 작업단위
    // 예시 : cart에 저장된 상품 중 하나라도 참조값이 없는 pcode, rollback, 모두 정상이면 commit
    // 트랜잭션 commit 모드가 auto에서 수동으로 변경
    public int insertMany(List<BuyVo> cart) { // 여러번(cart그기 만큼의) insert를 실행
        String sql = "insert into tbl_buy values (buy_pk_sql.nextval,?,?,? ,to_date)\n";
        Connection conn = null;
        PreparedStatement pstmt = null;
        int count = 0;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            conn.setAutoCommit(false); // ****auto commit 해제
            for (BuyVo vo : cart) {
                pstmt.setString(1, vo.getCustomid());
                pstmt.setString(2, vo.getPcode());
                pstmt.setInt(3, vo.getQuantity());
                pstmt.addBatch(); // **sql을 메모리에 모두 모아두기 insert sql에 대입되는 매개변수깂은 매번 다름
                count++;
            }
            pstmt.executeBatch(); // 모아둔 sql을 일괄실행. 실행 중에 무결성 오류 생기면
            conn.commit(); // //catch 에서 rollback
        } catch (SQLException e) { // 예외 발생 : 트랜잭션 처리
            // customid와 pcode는 참조테이블에 존재하는 값이 아니면 무결성 위반 오류
            try {
                conn.rollback();
            } catch (SQLException e1) {
            }
            count = -1;
            System.out.println("구매 불가능한 상품이 있습니다");
            System.out.println("장바구니 구매 실행 예외 발생 : " + e.getMessage());
        } finally { // 정상실행과 예외 모두에 대해 자원해제
            try { // 트랜잭션 처리를 위해 conn을 사용해야 하므로 직접 close함
                pstmt.close();
                conn.close();
            } catch (SQLException el) {
            }
        }
        return count;
    }

    public int money_of_dayByCustomer(String customid, String buydate) {
        String sql = "{ call money_of_day(?,?,?) }";
        int money = 0;
        try (
                Connection connection = getConnection();
                CallableStatement cstmt = connection.prepareCall(sql)) {
            // 프로시저의 IN 매개변수값 전달 : setXXX
            cstmt.setString(1, customid);
            cstmt.setString(2, buydate);

            // 프로시저 OUT 매개변수 1) 타입 설정
            cstmt.registerOutParameter(3, Types.NUMERIC);
            cstmt.executeUpdate(); // 프로시저 실행
            // OUT 매개변수 2) 결과값 가져오기 : getXXX
            money = cstmt.getInt(3);

        } catch (SQLException e) {
            System.out.println("money_of_day 프로시저 실행 예외 : " + e.getMessage());
        }

        return money;
    }
}
