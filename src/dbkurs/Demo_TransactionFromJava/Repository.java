package dbkurs.Demo_TransactionFromJava;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;


public class Repository {

    private Properties p = new Properties();
    private Connection con;
    CallableStatement stmt = null;
    ResultSet rs = null;

    public Repository(){
        try {
            p.load(new FileInputStream("src/dbKurs/DemoSP/Settings.properties"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
      
    public String addManufacturingElf(String elfName){

        String query = "call addManufacturingElfNoErrorHandling(?)";

        //Vi får inte tag i con-objektet om vi använder try-with-resources
        //ref: https://www.mysqltutorial.org/mysql-jdbc-transaction/
        try{
            con = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            CallableStatement stmt = con.prepareCall(query);

            stmt.setString(1, elfName);
            con.setAutoCommit(false);
            rs = stmt.executeQuery();
            con.commit();
        }
        catch (SQLException e){
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
            System.out.println("e.mess "+e.getMessage());
            return "Could not add elf "+elfName;
        }
        catch (Exception e){
            System.out.println("e.mess "+e.getMessage());
            return "Could not add elf "+elfName;
        }
        finally {
            try {
                if(rs != null)  rs.close();
                if(stmt != null) stmt.close();
                if(con != null) con.close();

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return elfName +" was added to database.";
    }
}
