package övn7_nissarnas_dejtingförslagsprogram.Repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import övn7_nissarnas_dejtingförslagsprogram.Models.Julfest.DtoPartyNisse;


public class JulfestRepository {

    private Properties p = new Properties();
    
    public JulfestRepository(){
        try {
            p.load(new FileInputStream("src/övn7_nissarnas_dejtingförslagsprogram/JulfestSettings.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    public List<DtoPartyNisse> getAllPartyNissar(){
        List<DtoPartyNisse> partyNissar = new ArrayList<>();
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT name, partyAlias FROM party.partynisse;")){
            
            while (rs.next()) {
                String name = rs.getString("name");
                String partyAlias = rs.getString("partyAlias");
                partyNissar.add(new DtoPartyNisse(name, partyAlias));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return partyNissar;
    }


}

