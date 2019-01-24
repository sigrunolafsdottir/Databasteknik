package övn6_addManufacturingElf;

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
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
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
            while (rs.next()) {
                errormessage = rs.getString("error");
            }
            if (!errormessage.equals("")) {
                return errormessage;
            }
        }
        catch (SQLException e){
            return e.getMessage() +"("+e.getErrorCode()+")";
        }
        catch (Exception e){
            e.printStackTrace();
            return "Could not add elf "+elfName;
        }
        return elfName +" was added to database.";
    }
}
