package dbkurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


//Try with resources saves a lot of closing...
public class VerySimpleDemoObjModel
{

    public static void main(String[] args) throws ClassNotFoundException {

        List <Customer> customers = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/MyClothesShop",
                "sigrun",
                "secretpassword");
             Statement stmt =  con.createStatement();
             ResultSet rs = stmt.executeQuery("select id, name, city from customer")) {


            Customer tempCustomer;

            while (rs.next()) {
                tempCustomer = new Customer();
                tempCustomer.setId(rs.getInt("id"));
                tempCustomer.setName(rs.getString("name"));
                tempCustomer.setCity(rs.getString("city"));
                customers.add(tempCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        customers.forEach(c -> c.printMe());

    }

}