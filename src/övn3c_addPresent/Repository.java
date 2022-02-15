package övn3c_addPresent;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;


public class Repository {

    private Properties p = new Properties();
    
    public Repository(){
        try {
            p.load(new FileInputStream("src/övn3c_addPresent/Settings.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public String addPresent(String presentName){
        String query = "insert into present (name) values (?)";
        String errormessage = "";
        int rowChanged = 0;
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(query)){

            stmt.setString(1, presentName);
            rowChanged = stmt.executeUpdate();
            
            if (rowChanged == 0){
                errormessage = presentName + "could not be added";
            }
            if (rowChanged > 1){
                errormessage = "Oooops, several "+presentName+" were added, very strange.";
            }
            if (!errormessage.equalsIgnoreCase("")){
                return errormessage;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "Could not add present "+presentName;
        }
        return presentName +" is now added to  db.";
    }
}
