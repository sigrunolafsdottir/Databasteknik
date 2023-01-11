package övn9_transaktioner;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class Repository {

 private Connection con;
    PreparedStatement countryCounterStmt = null;
    PreparedStatement getCountryIdStmt = null;
    PreparedStatement insertCountryStmt = null;
    PreparedStatement insertChildStmt = null;
    private Properties p = new Properties();
    
    public Repository(){
        try{
            p.load(new FileInputStream("src/övn9_transaktioner/Settings.properties"));
        }
         catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateChild(String childName, String address, String countryName){
        ResultSet rs = null;
        int amount = 0;
        int countryId = 0;

        //Vi får inte tag i con-objektet om vi använder try-with-resources
        //ref: https://www.mysqltutorial.org/mysql-jdbc-transaction/
        try {
            con = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            countryCounterStmt = con.prepareStatement(
                    //  "SELECT EXISTS(SELECT * FROM country WHERE name =  ?)"))}
                    "select count(*) as count from country where name = ?");
            getCountryIdStmt = con.prepareStatement(
                    "select id from country where name = ?");
            insertCountryStmt = con.prepareStatement(
                    "insert into country (name) values (?)");
            insertChildStmt = con.prepareStatement(
                    "insert into child (name, address, countryId) values (?, ?, ?)");
            
            countryCounterStmt.setString(1, countryName);
            rs = countryCounterStmt.executeQuery();
            
            while (rs.next()) {
                amount = rs.getInt("count");
            }
            System.out.println("Count "+ amount);
            
            if (amount > 0){  //landet finns, ingen anledning till transaktion
                getCountryIdStmt.setString(1, countryName);
                rs = getCountryIdStmt.executeQuery();
                while (rs.next()) {
                    countryId = rs.getInt("id");
                }
                insertChildStmt.setString(1, childName);
                insertChildStmt.setString(2, address);
                insertChildStmt.setInt(3, countryId);
                insertChildStmt.executeUpdate();
            }
            else{
                con.setAutoCommit(false);
                insertCountryStmt.setString(1, countryName);
                insertCountryStmt.executeUpdate();
                getCountryIdStmt.setInt(1, countryId);
                rs = getCountryIdStmt.executeQuery();
                while (rs.next()) {
                    countryId = rs.getInt("id");
                }
                insertChildStmt.setString(1, childName);
                insertChildStmt.setString(2, address);
                insertChildStmt.setInt(3, countryId);
                insertChildStmt.executeUpdate();
                con.commit();
            }
        }
        catch (SQLException e){
            //något verkar ha ändrat sig, connectionen stängs ner automatiskt
            //rollback-en görs också automatiskt
            e.printStackTrace();
            if (con != null) {
                try {
                    System.out.print("Transaction is being rolled back");
                    con.rollback();
                } 
                catch(SQLException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            if (con != null) {
                try {
                    System.out.print("Transaction is being rolled back");
                    con.rollback();
                } 
                catch(SQLException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
        finally {
            try {
                if(rs != null)  rs.close();
                if(countryCounterStmt != null) countryCounterStmt.close();
                if(getCountryIdStmt != null) getCountryIdStmt.close();
                if(insertCountryStmt != null) insertCountryStmt.close();
                if(insertChildStmt != null) insertChildStmt.close();
                if(con != null) con.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
