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

        List <Child> customers = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bigtomtedatabase?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
                "sigrun",
                "secretpassword");
             Statement stmt =  con.createStatement();
             ResultSet rs = stmt.executeQuery("select id, name, address from child")) {


            Child tempCustomer;

            while (rs.next()) {
                tempCustomer = new Child();
                tempCustomer.setId(rs.getInt("id"));
                tempCustomer.setName(rs.getString("name"));
                tempCustomer.setAddress(rs.getString("address"));
                customers.add(tempCustomer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        customers.forEach(c -> c.printMe());

    }

}