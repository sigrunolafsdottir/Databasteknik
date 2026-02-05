package övn6b_addManufacturingElfResignal;

import övn6_addManufacturingElf.*;
import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class Repository {

    private Properties p = new Properties();
    
    public Repository(){
        try {
            p.load(new FileInputStream("src/övn6_addManufacturingElf/Settings.properties"));
            //Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    //felhantering med resignal i handlers
    public String addManufacturingElf(String elfName){
       
        ResultSet rs = null;
        String query = "call addManufacturingElf(?)";
        
        String errormessage = "";
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             CallableStatement stmt = con.prepareCall(query)){

            stmt.setString(1, elfName);
            rs = stmt.executeQuery();
            
        }
        catch (SQLException e){
            //om vi resignal fångar vi det här
            System.out.println(e.getMessage() +" ("+e.getErrorCode()+")");
            return "Could not add elf "+elfName;
        }
        catch (Exception e){
            //vi bör aldrig komma hit
            e.printStackTrace();
            return "Could not add elf "+elfName;
        }
        return elfName +" was added to database.";
    }
}
