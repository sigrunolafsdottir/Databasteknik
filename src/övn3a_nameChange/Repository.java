package övn3a_nameChange;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;


public class Repository {

    private Properties p = new Properties();
    
    public Repository(){
        try {
            p.load(new FileInputStream("src/övn3a_nameChange/Settings.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    public String updateElfName(String oldElfName, String newElfName){
       
        String query = "UPDATE elf SET name = ? where name like ? ;";
        int rowChanged = 0;
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(query)){

            stmt.setString(1, newElfName);
            stmt.setString(2, oldElfName);
            rowChanged = stmt.executeUpdate();
            
            if (rowChanged == 0){
                return "There was no elf named " + oldElfName;
            }
            if (rowChanged > 1){
                return "Oooops, several "+oldElfName+"s changed";
            }

        }
        catch (Exception e){
            e.printStackTrace();
            return "Could not change name of elf "+oldElfName;
        }
        return oldElfName +" is now named " + newElfName;
    }
}
