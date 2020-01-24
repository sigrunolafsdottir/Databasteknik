package övn10_map;

import övn1_tomtensDashboard.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class Repository {

    private Properties p = new Properties();
    
    public Repository(){
        try {
            p.load(new FileInputStream("src/övn1_tomtensDashboard/Settings.properties"));
            Class.forName("com.mysql.jdbc.Driver");
            //I senare versioner: com.mysql.cj.jdbc.Driver
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    public Map<Integer,Elf> getAllElfs(){
        Map<Integer,Elf> allElves = new HashMap<>();
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from elf")){
            
            while (rs.next()) {
          
                int id = rs.getInt("id");
                String name = rs.getString("name");
                allElves.put(id, new Elf(id, name));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allElves;
    }


}
