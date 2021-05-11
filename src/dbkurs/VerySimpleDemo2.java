package dbkurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//Try with resources saves a lot of closing...
public class VerySimpleDemo2 {

    public static void main(String[] args) throws ClassNotFoundException {

        try (Connection con = DriverManager.getConnection(
                             "jdbc:mysql://localhost:3306/MyClothesShop",
                             "sigrun",
                             "secretpassword");
            Statement stmt =  con.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, city from MyClothesShop.customer"))
        {

            while (rs.next()) {
                String city = rs.getString("city");
                int id = rs.getInt("id");
                String name = rs.getString("name");
                

                System.out.println("id: " + id + ", name: " + name + ", city: " + city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
