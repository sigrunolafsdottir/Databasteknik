package övn3b_deleteNisse;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;


public class Repository {

    private Properties p = new Properties();
    
    public Repository(){
        try {
            p.load(new FileInputStream("src/övn3b_deleteNisse/Settings.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    //utgår från att det ligger en on delete cascade på tabellerna för
    //tillverkningsnisse och säkerhetsnisse
    
    public String deleteElf(String elfName){
       
        String query = "delete from  elf  where name = ?;";
        int rowChanged = 0;
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(query)){

            stmt.setString(1, elfName);
            rowChanged = stmt.executeUpdate();
            
            if (rowChanged == 0){
                return "There was no elf named " + elfName;
            }
            if (rowChanged > 1){
                return "Oooops, several "+elfName+"s changed";
            }

        }
        catch (Exception e){
            e.printStackTrace();
            return "Could not change name of elf "+elfName;
        }
        return elfName +" is now deleted from db.";
    }
}
