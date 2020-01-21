package övn4_printChildren;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import övn4_printChildren.Models.*;


public class Repository {
    
    private Connection con;
    private Properties p = new Properties();
    
    public Repository(){
        try{
            p.load(new FileInputStream("src/övn4_printChildren/Settings.properties"));
            Class.forName("com.mysql.jdbc.Driver");
        }
         catch (Exception e){
            e.printStackTrace();
        }
    }


    
    public List<Present> getWishlistForChildByChildId(int childId){
        
        List<Present> presents = new ArrayList<>();    
        ResultSet rs = null;
        String query = "select present.id, present.name from present "+
                "inner join wishes on wishes.presentId = present.id "+
                "inner join child on wishes.childId = child.id "+
                "where child.id = ?";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(query)){
            

            stmt.setString(1, childId+"");
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                presents.add(new Present(
                        rs.getInt("id"),rs.getString("name")));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return presents;
    }
    
        public List<Present> getGiftsForChildByChildId(int childId){
        
        List<Present> presents = new ArrayList<>();    
        ResultSet rs = null;
        String query = "select present.id, present.name "
                + "from present inner join gets on gets.presentId = present.id "
                + "inner join child on gets.childId = child.id where child.id = ?";
                
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(query)){
            
            stmt.setString(1, childId+"");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                presents.add(new Present(rs.getInt("id"),rs.getString("name")));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return presents;
    }
    
    

    
        public Country getCountryByChildId(int childId){
        Country country = new Country();    
        ResultSet rs = null;
        String query = "select country.id, country.name "
                + "from country inner join child "
                + "on child.countryId=country.id "
                + "where child.id = ?";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(query)){
            
            stmt.setString(1, childId+"");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                country = new Country(
                        rs.getInt("id"),rs.getString("name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return country;
    }
    
    public Child getChildById(int id){
        Child child = new Child();  
        Country country = getCountryByChildId(id);
        List<Present> wishlist = getWishlistForChildByChildId(id);
        List<Present> gifts = getGiftsForChildByChildId(id);
        ResultSet rs = null;
        String query = "select child.id, child.name, child.address, "
                + "child.nice "
                + "from child inner join country on "
                + "child.countryId = country.id "
                + "where child.id = ?";
        
        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             PreparedStatement stmt = con.prepareStatement(query)){
            
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                child = new Child(rs.getInt("id"),rs.getString("name"), 
                        rs.getString("address"),
                        country, wishlist, gifts, rs.getBoolean("nice"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return child;
    }
    
    
    
    public List<Child> getAllChildren(){
        List<Child> children = new ArrayList<>();    
        List<Integer> allChildIds = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(p.getProperty("connectionString"),
                             p.getProperty("name"),
                             p.getProperty("password"));
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id FROM child");){
            
            while (rs.next()) {
                allChildIds.add(rs.getInt("id"));
            }
            
            children = allChildIds.stream()
                    .map(i -> getChildById(i))
                    .collect(Collectors.toList());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return children;
    }

}
