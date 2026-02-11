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

        //String query = "call addManufacturingElfNoErrorHandling(?)";
        //transaktionshantering i SP
        String query = "call addManufacturingElftestDemo(?, ?)";
        boolean success = false;

        //Vi får inte tag i con-objektet om vi använder try-with-resources
        //ref: https://www.mysqltutorial.org/mysql-jdbc-transaction/
        try{
            con = DriverManager.getConnection(p.getProperty("connectionString"),
                    p.getProperty("name"),
                    p.getProperty("password"));
            CallableStatement stmt = con.prepareCall(query);

            stmt.setString(1, elfName);
            stmt.registerOutParameter(2, Types.BOOLEAN);

            rs = stmt.executeQuery();
            success = stmt.getBoolean(2);
            System.out.println(success);  //syns bara om success
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println(success);
            //e.printStackTrace();
            System.out.print("Transaction is being rolled back");
            return "Could not add elf "+elfName;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(success);
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
