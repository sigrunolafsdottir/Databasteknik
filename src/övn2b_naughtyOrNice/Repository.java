package övn2b_naughtyOrNice;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class Repository {
    
    private Connection con;
    private Properties p = new Properties();
    
    public Repository(){
        try{
            p.load(new FileInputStream("src/övn2a_naughtyOrNice/Settings.properties"));
        }
         catch (Exception e){
            e.printStackTrace();
        }
    }

    public Child getChildByName(String name){   // Ambrosia'; drop database tomtedb;'
        ResultSet rs = null;
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
                PreparedStatement stmt = con.prepareStatement("select * from child where name = ?")){
            
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            Child child = null;
            
            while (rs.next()) {
                child = new Child(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getBoolean("nice"));
            }
            return child;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        return null;
    }

}
