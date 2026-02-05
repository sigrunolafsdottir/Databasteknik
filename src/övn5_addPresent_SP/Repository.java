package övn5_addPresent_SP;

import övn4_printChildren.Models.Child;

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
            p.load(new FileInputStream("src/övn5_addPresent_SP/Settings.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    public String addPresent(String childName, String presentName){
       
        ResultSet rs = null;
        String query = "call insertGift(?, ?)";
        //String query = "call addPresentErrorHandler(?)";
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             CallableStatement stmt = con.prepareCall(query)){

            stmt.setString(1, childName);
            stmt.setString(2, presentName);
            rs = stmt.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("test"));
            }
        }
        catch (Exception e){
            System.out.println("e.mess "+e.getMessage());
            return "Could not give "+childName+" a "+presentName;
        }
        return childName + " got a "+ presentName;
    }
}
