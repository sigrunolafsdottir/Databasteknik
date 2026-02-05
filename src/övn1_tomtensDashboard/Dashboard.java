package övn1_tomtensDashboard;

import java.util.List;
import static java.util.stream.Collectors.toList;


public class Dashboard {

    public Dashboard() throws InterruptedException{

        Repository r = new Repository();

        //List<Elf> allElves = r.getAllElfs();
        
        while(true){
            System.out.println("Number of employees : " +r.getAllElfs().size());
            System.out.println("Employee names : " +
                    r.getAllElfs().stream().map(Elf::getName).toList());

            List<Elf> demoElves = r.getAllElfs();
            demoElves.forEach(e -> System.out.println("x "+e.getName()));

            System.out.println("Number of kids : " +r.getNumberOfKids());
            System.out.println("Average niceness : " +r.getNicenessAverage());
            Thread.sleep(2000);
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        Dashboard d = new Dashboard();
    }

}
