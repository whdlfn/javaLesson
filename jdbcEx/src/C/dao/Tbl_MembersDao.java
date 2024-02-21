package C.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import C.vo.Tbl_MembersVo;
import jdbc.day1.OracleConnectionUtil;

public class Tbl_MembersDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 회원가입
    public void join(Tbl_MembersVo vo) {
        String sql = "insert into tbl_members(code, name, email, Phone_number, age)\n" +
                "values (?,?,?,?,?)";
        try (
                Connection conn = OracleConnectionUtil.getConnection(); // 1) 서버와의 연결
                PreparedStatement pstmt = conn.prepareStatement(sql)) { // 2) 연결된 서버로 실행할 sql 정달. 서버가 컴파일
            pstmt.setString(1, vo.getCode());
            pstmt.setString(2, vo.getName());
            pstmt.setString(3, vo.getEmail());
            pstmt.setString(4, vo.getPhone_number());
            pstmt.setInt(5, vo.getAge());

            pstmt.executeUpdate(); // 리턴값 int 는 반영된 행의 개수를 리턴 // 3) 연결된 서버에 실행 요청
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 : " + e.getMessage());
        }
    }

    //회원 수정
    public void modify(Tbl_MembersVo vo) {
        String sql = "update tbl_members set email = ?, age = ?  where code = ?";
        try (
                Connection conn = OracleConnectionUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 할일 2 : 매개변수 바인딩(매개변수 타입에 맞는 메소드를 실행합시다)
            pstmt.setString(1, vo.getEmail());
            pstmt.setInt(2, vo.getAge());
            pstmt.setString(3, vo.getCode());

            pstmt.executeUpdate(); // 리턴값 int 는 반영된 행의 개수를 리턴.
        } catch (SQLException e) {
            System.out.println("SQL 실행 예외 발생 : " + e.getMessage());
        }
    }


    // 회원 정보 *PK로 조회(조회 결과 행 개수 있으면 1개 없으면 0개) : select * from tbl_custom where
    public Tbl_MembersVo getMembers(String code) {
        Tbl_MembersVo vo = null;
        String sql = "select * from tbl_members where code =?";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) 
            {
            pstmt.setString(1, code);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {        //조회결과가 있으면 true, 없으면 false
                vo = new Tbl_MembersVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5));
                
            }
        } catch (SQLException e) {
            System.out.println("getMembers 예외 발생 :" + e.getMessage());
        }
        return vo;
    }

    //회원탈퇴
    public void delete(String code) {
        String sql = "delete from tbl_members where code = ?";
        try (
                Connection conn = OracleConnectionUtil.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 할일 2 : 매개변수 바인딩(매개변수 타입에 맞는 메소드를 실행합시다)
            pstmt.setString(1, code);

            pstmt.executeUpdate(); // 리턴값 int 는 반영된 행의 개수를 리턴.
        } catch (SQLException e) {
            System.out.println("join 실행 예외 발생 : " + e.getMessage());
        }
    }


    // 관리자를 위한 기능 모든 회원정보 조회 select * from tbl_custom
    public List<Tbl_MembersVo> allCustomers() {
        List<Tbl_MembersVo> list = new ArrayList<>();
        String sql = "select * from tbl_members";

        try (Connection connection = getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(new Tbl_MembersVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5)));
            }
        } catch (SQLException e) {
            System.out.println("모든 회원정보 조회 오류 " + e.getMessage());
        }
        return list;
    }

}
