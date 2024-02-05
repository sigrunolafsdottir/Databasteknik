package övn4_printChildern_AltSolution;

import övn4_printChildern_AltSolution.Models.ChildPresentMapping;
import övn4_printChildern_AltSolution.Models.Child;
import övn4_printChildern_AltSolution.Models.Country;
import övn4_printChildern_AltSolution.Models.Present;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Repository {

    private Connection con;
    private Properties p = new Properties();

    public Repository() {
        try {
            p.load(new FileInputStream("src/övn4_printChildren/Settings.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ChildPresentMapping> getAllWishes() {
        List<ChildPresentMapping> wishes = new ArrayList<>();

        //drar ut alla önskningar
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                p.getProperty("name"),
                p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT child.id as childId, child.name as childName, " +
                     "child.nice as childNice, child.address as childAddress, " +
                     "country.id as countryId, country.name as countryName, " +
                     "present.id as presentId, present.name as whishes " +
                     "FROM tomtedatabasedemo2.present " +
                     "join wishes on present.id=wishes.presentId " +
                     "join child on wishes.childId= child.id " +
                     "join country on child.countryId = country.id;");) {

            while (rs.next()) {
                Child c = new Child(rs.getInt("childId"), rs.getString("childName"),
                        rs.getString("childAddress"),
                        new Country(rs.getInt("countryId"), rs.getString("countryName")),
                        rs.getBoolean("childNice"));

                Present p = new Present(rs.getInt("presentId"), rs.getString("whishes"));

                wishes.add(new ChildPresentMapping(c, p));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return wishes;
    }

    public List<ChildPresentMapping> getAllGifts() {
        List<ChildPresentMapping> gifts = new ArrayList<>();

        //drar ut alla gåvor
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
                     "inner join present on present.id=gets.presentId;");) {

            while (rs.next()) {
                Child c = new Child(rs.getInt("childId"), rs.getString("childName"),
                        rs.getString("childAddress"),
                        new Country(rs.getInt("countryId"), rs.getString("countryName")),
                        rs.getBoolean("childNice"));

                Present p = new Present(rs.getInt("presentId"), rs.getString("gift"));

                gifts.add(new ChildPresentMapping(c, p));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gifts;
    }

}