package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.day1.OracleConnectionUtil;
import project.vo.CustomerVo;

public class TblCustomerDao {
    public static final String DRIVER ="oracle.jdbc.driver.OracleDriver";
    public static final String URL ="jdbc:oracle:thin:@//localhost:1521/XE";
    public static final String USERNAME ="c##idev";
    private static final String PASSWORD ="12345";

    private Connection getConnection() throws SQLException {
    	Connection conn = null;
    	try {
    		Class.forName(DRIVER);
    		conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    	return conn;
    }

    // 회원 가입
    public void join(CustomerVo vo) {
        String sql = "insert into tbl_custom(custom_id, name, email,age,reg_date)\n" +
                "values (?,?,?,?,sysdate)";
        try (
                Connection conn = OracleConnectionUtil.getConnection(); // 1) 서버와의 연결
                PreparedStatement pstmt = conn.prepareStatement(sql)) { // 2) 연결된 서버로 실행할 sql 정달. 서버가 컴파일
            pstmt.setString(1, vo.getCustomId());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setInt(4, vo.getAge());

            pstmt.executeUpdate(); // 리턴값 int 는 반영된 행의 개수를 리턴 // 3) 연결된 서버에 실행 요청
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 : " + e.getMessage());
        }
    }

    // 회원정보 수정(이메일, 나이 수정)
    public void modify(CustomerVo vo) {
        String sql = "update tbl_custom set email = ?, age = ?  where custom_id = ?";
        // 할 일 1 : sql작성하기 (매개변수 표시 정확히 합시다)
        try (
                Connection conn = OracleConnectionUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 할일 2 : 매개변수 바인딩(매개변수 타입에 맞는 메소드를 실행합시다)
            pstmt.setString(1, vo.getEmail());
            pstmt.setInt(2, vo.getAge());
            pstmt.setString(3, vo.getCustomId());

            pstmt.executeUpdate(); // 리턴값 int 는 반영된 행의 개수를 리턴.
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 : " + e.getMessage());
        }
    }

    // 회원 탈퇴
    public void delete(String customerID) {
        String sql = "delete from tbl_custom where custom_id = ?";
        try (
                Connection conn = OracleConnectionUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 할일 2 : 매개변수 바인딩(매개변수 타입에 맞는 메소드를 실행합시다)
            pstmt.setString(1, customerID);

            pstmt.executeUpdate(); // 리턴값 int 는 반영된 행의 개수를 리턴.
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }
    }

    // 회원 정보 *PK로 조회(조회 결과 행 개수 있으면 1개 없으면 0개) : select * from tbl_custom where
    // custom_id =?
    // 리턴 타입 : CustomerVo
    public CustomerVo getCustomer(String customerId) {
        CustomerVo vo = null;
        String sql = "select * from tbl_custom where custom_id =?";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) 
            {
            pstmt.setString(1, customerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {        //조회결과가 있으면 true, 없으면 false
                vo = new CustomerVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5));
                
            }
        } catch (SQLException e) {
            System.out.println("getCustomer 예외 발생 :" + e.getMessage());
        }
        return vo;
    }

    // 관리자를 위한 기능 모든 회원정보 조회 select * from tbl_custom
    public List<CustomerVo> allCustomers() {
        List<CustomerVo> list = new ArrayList<>();
        String sql = "select * from tbl_custom";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new CustomerVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5)));
            }
        } catch (SQLException e) {
            System.out.println("예외 발생 " + e.getMessage());
        }
        return list;
    }
}