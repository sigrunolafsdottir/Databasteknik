package dbkurs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


//Try with resources saves a lot of closing...
public class VerySimpleDemoProperties {

    public static void main(String[] args) throws  FileNotFoundException, IOException {

        Properties p = new Properties();
        p.load(new FileInputStream("src/dbkurs/Settings.properties"));

        try (Connection con = DriverManager.getConnection(
                p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt =  con.createStatement();
             ResultSet rs = stmt.executeQuery("select id, name, city from customer")) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String city = rs.getString("city");

                System.out.println("id: " + id + ", name: " + name + ", city: " + city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}