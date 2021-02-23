package övn1_tomtensDashboard;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class RepositoryMockup  implements IRepository {

    private Properties p = new Properties();
    List<Elf> allElves = new ArrayList<>();

    public RepositoryMockup(){
        Elf a = new Elf(1, "Emma");
        Elf b = new Elf(2, "Frippe");
        Elf c = new Elf(3, "Hannes");
        allElves.add(a);
        allElves.add(b);
        allElves.add(c);
    }
      
    public List<Elf> getAllElfs(){
        return allElves;
    }

    public int getRowCount(String tableName){
        if (tableName.equals("child")){
            return 2;
        }
        else if (tableName.equals("elf")){
            return allElves.size();
        }
        else return 1;
    }
    
    public int getNumberOfKids(){
        return 2;
    }
    
    public double getNicenessAverage(){
        return 3.5;
    }
    

}
