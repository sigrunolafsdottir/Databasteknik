package övn10_map;

import övn1_tomtensDashboard.*;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;


public class Dashboard {
    
    public Dashboard() throws InterruptedException{
        Repository r = new Repository();
         Map<Integer,Elf> allElves = r.getAllElfs();

        System.out.println("Number of employees : " +allElves.size());
        System.out.println("Employee names : ");
        allElves.forEach((k, v) -> System.out.println(v.getName()));
    }
    
    public static void main(String args[]) throws InterruptedException {
        Dashboard d = new Dashboard();
    }

}
