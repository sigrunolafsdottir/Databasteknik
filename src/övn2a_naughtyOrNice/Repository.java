package övn2a_naughtyOrNice;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;


public class Repository {
    
    private Properties p = new Properties();
    
    public Repository(){
        try{
            p.load(new FileInputStream("src/övn2a_naughtyOrNice/Settings.properties"));

        }
         catch (Exception e){
            e.printStackTrace();
        }
    }

    public Child getChildByName(String name){

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM child WHERE name='"+name + "'");){
            //SELECT * FROM child WHERE name='_Doris_'
            
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
