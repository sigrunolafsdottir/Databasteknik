package dbkurs.DemoSP;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;


public class Repository {

    private Properties p = new Properties();
    
    public Repository(){
        try {
            p.load(new FileInputStream("src/dbKurs/DemoSP/Settings.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    public String addCountry(String countryName){
       
        ResultSet rs = null;
        String query = "call addCountry(?)";
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             CallableStatement stmt = con.prepareCall(query)){

            stmt.setString(1, countryName);
            rs = stmt.executeQuery();
        }
        catch (Exception e){
            System.out.println("e.mess "+e.getMessage());
            return "Could not add country "+countryName;
        }
        return countryName +" was added to database.";
    }
}
