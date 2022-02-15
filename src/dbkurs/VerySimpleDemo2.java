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
                             "jdbc:mysql://localhost:3306/bigtomtedatabase?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
                             "sigrun",
                             "secretpassword");
            Statement stmt =  con.createStatement();
            ResultSet rs = stmt.executeQuery("select id, name, address from child"))
        {

            while (rs.next()) {
                String adress = rs.getString("address");
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println("id: " + id + ", name: " + name + ", address: " + adress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
