package övn7_nissarnas_dejtingförslagsprogram.Repository;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import övn7_nissarnas_dejtingförslagsprogram.Models.Nisse.*;


public class NisseRepository {
        private Properties p = new Properties();
    
    public NisseRepository(){
        try {
            p.load(new FileInputStream("src/övn7_nissarnas_dejtingförslagsprogram/NisseSettings.properties"));
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    public List<DtoMakerElf> getAllMakerElfs(){
        List<DtoMakerElf> makerElves = new ArrayList<>();
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from elf inner join makerelf on makerelf.elfId = elf.id;")){
            
            while (rs.next()) {
                String name = rs.getString("name");
                makerElves.add(new DtoMakerElf(name));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return makerElves;
    }

   public List<DtoIntelligenceElf> getAllIntelligenceElfs(){
        List<DtoIntelligenceElf> intElves = new ArrayList<>();
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
                Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name, securityLevel from elf\n" +
                "inner join intelligenceelf on intelligenceelf.elfId = elf.id;")){
            
            while (rs.next()) {
                String name = rs.getString("name");
                int securityLevel = rs.getInt("securityLevel");
                intElves.add(new DtoIntelligenceElf(name, securityLevel));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return intElves;
    }
}
