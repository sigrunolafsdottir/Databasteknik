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
            Class.forName("com.mysql.jdbc.Driver");
        }
         catch (Exception e){
            e.printStackTrace();
        }
    }

    public Child getChildByName(String name){
        Child child = new Child();
        ResultSet rs = null;
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
                PreparedStatement stmt = con.prepareStatement("select * from child where name = ?")){
            
            stmt.setString(1, name);
            rs = stmt.executeQuery();
            
            
            while (rs.next()) {
                child = new Child(rs.getInt("id"),rs.getString("name"),rs.getBoolean("nice"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(rs != null)
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return child;
    }

}
