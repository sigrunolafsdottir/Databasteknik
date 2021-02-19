package dbkurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerySimpleDemo {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, Exception {
        
        //Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try{
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/MyClothesShop?serverTimezone=UTC&useSSL=false",
                "sigrun",
                "secretpassword");

            stmt = con.createStatement();
            rs = stmt.executeQuery("select id, name, "
                    + "city from customer");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");

                System.out.println("id: " + id + 
                    ", name: " + name + ", city: " + city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
            Exception ex = new Exception();
            throw ex;
        }

        finally {
            
            System.out.println("Doing finally stuff");
            
            if(rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if (stmt != null)
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            if( con != null)
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        
        System.out.println("Doing AFTER-finally stuff");
    }
    
}
