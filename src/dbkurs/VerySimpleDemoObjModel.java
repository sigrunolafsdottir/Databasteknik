package dbkurs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;



//Try with resources saves a lot of closing...
public class VerySimpleDemoObjModel
{

    public static void main(String[] args) throws ClassNotFoundException, IOException {

        Properties prop = new Properties();
        prop.load(new FileInputStream("src/dbkurs/Settings.properties"));

        List <Child> children = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(
                prop.getProperty("connectionString"),
                prop.getProperty("name"),
                prop.getProperty("password"));
             Statement stmt =  con.createStatement();
             ResultSet rs = stmt.executeQuery("select id, name, address from child")) {


            Child tempChild;

            while (rs.next() ) {
                tempChild = new Child();
                tempChild.setId(rs.getInt("id"));
                tempChild.setName(rs.getString("name"));
                tempChild.setAddress(rs.getString("address"));
                children.add(tempChild);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        children.forEach(c -> c.printMe());

    }

}