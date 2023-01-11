package dbkurs.Demo_Felhantering;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;


public class RepositoryResignal {

    private Properties p = new Properties();

    public RepositoryResignal(){
        try {
            p.load(new FileInputStream("src/övn6_addManufacturingElf/Settings.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    

    public String addManufacturingElf(String child, String present){
       
        ResultSet rs = null;
        String query = "call insertGift2(?,?)";
        
        String errormessage = "";
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             CallableStatement stmt = con.prepareCall(query)){

            stmt.setString(1, child);
            stmt.setString(2, present);
            rs = stmt.executeQuery();

        }

        catch (SQLException e){
            //om vi resignal fångar vi det här
            System.out.println(e.getMessage() +" ("+e.getErrorCode()+")");
            return "Gåvan misslyckades";
        }
        catch (Exception e){
           //vi bör aldrig komma hit
            e.printStackTrace();
            return "Gåvan misslyckades";
        }
        return "Allt gick bra";
    }
}
