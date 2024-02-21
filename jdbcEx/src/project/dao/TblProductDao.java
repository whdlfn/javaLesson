package project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdbc.day1.OracleConnectionUtil;
import project.vo.ProductVo;

public class TblProductDao {
    public static final String URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    public static final String USERNAME = "c##idev";
    private static final String PASSWORD = "12345";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public List<ProductVo> selectByCategory(String category) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * from tbl_product where category = ? order by pname";

        try (
                Connection connection = OracleConnectionUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, category);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ProductVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }
            // dao 메소드에는 특별한 목적이 아니면 출력문 작성 안 함!
        } catch (SQLException e) {
            System.out.println("예외 발생 " + e.getMessage());
        }
        return list; // select 조회 결과를 자바 객체 list와 매핑하여 리턴
    }

    public List<ProductVo> selectByPname(String pname) {
        List<ProductVo> list = new ArrayList<>();
        String sql = "SELECT * FROM TBL_PRODUCT  \r\n" +
                "WHERE pname LIKE '%'|| ? || '%' \r\n";

        try (Connection connection = OracleConnectionUtil.getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, pname);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                list.add(new ProductVo(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)));
            }

        } catch (SQLException e) {
            System.out.println("selectBycategory 예외 발생" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    
    public Map<String, Integer> getPriceTable() {
        Map<String, Integer> map = new HashMap<>();
        String sql = "SELECT pcode, price from tbl_product";

        try (
                Connection connection = OracleConnectionUtil.getConnection();
                PreparedStatement ps = connection.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                map.put(rs.getString(1), // key
                        rs.getInt(2)); // value
            }
        } catch (SQLException e) {
            System.out.println("getProceTable 예외 발생 " + e.getMessage());
        }
        return map;
    }

}
