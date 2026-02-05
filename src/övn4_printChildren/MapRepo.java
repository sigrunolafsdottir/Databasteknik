package övn4_printChildren;

import övn4_printChildren.Models.Child;
import övn4_printChildren.Models.Country;
import övn4_printChildren.Models.Present;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class MapRepo {

    private Connection con;
    private Properties p = new Properties();

    public MapRepo(){
        try{
            p.load(new FileInputStream("src/övn4_printChildren/Settings.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public Map<Integer, Child> getAllChildren(){
        Map<Integer, Child> childMap = new HashMap<>();

        //drar ut alla önskningar först
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT child.id as childId, child.name as childName, "+
                             "child.nice as childNice, child.address as childAddress, "+
                     "country.id as countryId, country.name as countryName, "+
                     "present.id as presentId, present.name as whishes "+
                     "FROM tomtedatabasedemo2.present "+
                     "join wishes on present.id=wishes.presentId "+
                     //right join för att få med alla barn, även dem som inte har önskningar
                     "right join child on wishes.childId= child.id "+
                     "join country on child.countryId = country.id;");){

            while (rs.next()) {
                int childId = rs.getInt("childId");
                if (childMap.containsKey(childId)){   //lägg till ett önskning i befintligt childs lista
                    Child child = childMap.get(childId);
                    child.addWish(new Present(rs.getInt("presentId"), rs.getString("whishes")));
                    childMap.put(childId, child);
                }
                else{   //skapa ett nytt barn
                    Child tempChild = new Child(childId, rs.getString("childName"),
                            rs.getString("childAddress"), new Country(rs.getInt("countryId"),
                            rs.getString("countryName")),
                            new ArrayList<Present>(), new ArrayList<Present>(), rs.getBoolean("childNice"));

                    if (rs.getInt("presentId") != 0) {
                        tempChild.addWish(new Present(rs.getInt("presentId"), rs.getString("whishes")));
                    }

                    childMap.put(childId, tempChild);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT child.id as childId, child.name as childName, " +
                     "child.nice as childNice, child.address as childAddress," +
                     "country.id as countryId, country.name as countryName, present.id as presentId, " +
                     "present.name as gift FROM tomtedatabasedemo2.child\n" +
                     "inner join country on child.countryId = country.id\n" +
                     "inner join gets on gets.childId=child.id\n" +
                     " inner join present on present.id=gets.presentId;");){

            while (rs.next()) {
                int childId = rs.getInt("childId");
                if (childMap.containsKey(childId)){   //lägg till en gåva i befintligt childs lista
                    Child child = childMap.get(childId);
                    child.addGift(new Present(rs.getInt("presentId"), rs.getString("gift")));
                    childMap.put(childId, child);
                }
                else{   //skapa ett nytt barn (detta barnet hade inga önskningar)
                    Child tempChild = new Child(childId, rs.getString("childName"),
                            rs.getString("childAddress"), new Country(rs.getInt("countryId"),
                            rs.getString("countryName")),
                            new ArrayList<Present>(), new ArrayList<Present>(), rs.getBoolean("childNice"));

                    tempChild.addGift(new Present(rs.getInt("presentId"), rs.getString("gift")));

                    childMap.put(childId, tempChild);
                }

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return childMap;
    }

}
