package C.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import C.vo.Tbl_Buy_MenuVo;

public class TbL_Buy_MenuDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    // 구매하기
    public int insert(Tbl_Buy_MenuVo vo) {
        String sql = "INSERT INTO TbL_Buy_Menu VALUES (buy_pk_sql.nextval, ?, ?, ?, SYSDATE)";
        int result = 0;
    
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vo.getCustom_id());
            pstmt.setString(2, vo.getMenu_id());
            pstmt.setInt(3, vo.getMenu_quantity());
    
            result = pstmt.executeUpdate();
    
        } catch (SQLException e) {
            System.out.println("구매하기 실행 예외 발생 : " + e.getMessage());
        }
        return result;
    }
    
}
