package övn1_tomtensDashboard;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
      
    public List<Elf> getAllElfs(){
        List<Elf> allElves = new ArrayList<>();
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from elf")){
            
            while (rs.next()) {
          
                int id = rs.getInt("id");
                String name = rs.getString("name");
                allElves.add(new Elf(id, name));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allElves;
    }

    private int getRowCount(String tableName){
        int count = -1;
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
                Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) as no from " + tableName)){

            while (rs.next()) {
                count = rs.getInt("no");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return count;
    }
    
    public int getNumberOfKids(){
        return getRowCount("child");
    }
    
    public double getNicenessAverage(){
        double nicenessAverage = -1;
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select avg(nicenumber) as avg from report")   ){

            while (rs.next()) {
                nicenessAverage = rs.getDouble("avg");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return nicenessAverage;
    }
    

}
