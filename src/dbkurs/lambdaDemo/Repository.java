package dbkurs.lambdaDemo;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    public List<Child> getAllChildren() {


        List<Child> children = new ArrayList<>();

            try(
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/bigtomtedatabase?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
                "sigrun",
                "secretpassword");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select id, name, address from child"))

        {

            Child tempChild;

            while (rs.next()) {
                tempChild = new Child();
                tempChild.setId(rs.getInt("id"));
                tempChild.setName(rs.getString("name"));
                tempChild.setAddress(rs.getString("address"));
                children.add(tempChild);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return children;
    }

    public List<Elf> getAllElfs(){
        List<Elf> allElves = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigtomtedatabase?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true",
                "sigrun",
                "secretpassword");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from elf")){

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                allElves.add(new Elf(id, name));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return allElves;
    }
}
