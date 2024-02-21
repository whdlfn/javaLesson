package C.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import C.vo.Tbl_MenuVo;


public class Tbl_MenuDao {
       public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<Tbl_MenuVo> allList() {
        List<Tbl_MenuVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_MENU";
    
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
    
            while (rs.next()) {
                list.add(new Tbl_MenuVo(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
    
        } catch (SQLException e) {
            System.out.println("모든 메뉴 조회 오류 " + e.getMessage());
        }
    
        return list;
    }

    public Tbl_MenuVo getMenu(String menuCode) {
        Tbl_MenuVo menu = null;
        String sql = "SELECT * FROM TBL_MENU WHERE MCODE = ?";
    
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, menuCode);
    
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                menu = new Tbl_MenuVo(
                        rs.getString("mcode"),
                        rs.getString("mname"),
                        rs.getInt("mprice"));
            }
        } catch (SQLException e) {
            System.out.println("메뉴 조회 오류: " + e.getMessage());
        }
    
        return menu;
    }
    
    

}
