package dbkurs.Demo_Felhantering;

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
            p.load(new FileInputStream("src/övn6_addManufacturingElf/Settings.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    
    //Fångar felmeddelanden med select
    public String addManufacturingElf(String child, String present){
       
        ResultSet rs = null;
        String query = "call insertGift(?,?)";
        
        String errormessage = "";
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             CallableStatement stmt = con.prepareCall(query)){

            stmt.setString(1, child);
            stmt.setString(2, present);
            rs = stmt.executeQuery();
            
            //om vi skickar ett selectat errormessage fångar vi det här
            while (rs != null && rs.next()) {
                errormessage = rs.getString("error");
            }
            if (!errormessage.equals("")) {
                return errormessage;
            }
        }
       
        catch (Exception e){
           
            e.printStackTrace();
            return "Gåvan misslyckades";
        }
        return "Allt gick bra";
    }
}
