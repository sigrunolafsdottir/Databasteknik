package övn8_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class GetAllBosses {
    
    int index;
    
    List <Elf> elfs = Arrays.asList(
            new Elf(1,"Santa", 0), 
            new Elf(2,"A", 1), 
            new Elf(3,"B", 1), 
            new Elf(4,"C", 1), 
            new Elf(5,"AA", 2), 
            new Elf(6,"AB", 2), 
            new Elf(7,"AC", 2), 
            new Elf(8,"AAA", 5), 
            new Elf(9,"AAB", 5), 
            new Elf(10,"AAAA", 8), 
            new Elf(11,"AAAAA", 10),
            new Elf(12,"BA", 3),
            new Elf(13,"BB", 3),
            new Elf(14,"CA", 4)
            );
    
    public List<String> getAllBosses(Elf elfToCheck, 
            List<String> bosses){        
        
        for(Elf e : elfs){
            if (e.getId() == elfToCheck.getBoss()){
                bosses.add(e.getName());
                getAllBosses(e, bosses);
            }
        }
        return bosses;  //när vi kommit till roten får vi ingen träff
    }

    
    public GetAllBosses () {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Get all bosses "
                    + "for what index in elf list:");
            index = sc.nextInt();
            List<String> bosses = new ArrayList<>();
            System.out.println(getAllBosses
                (elfs.get(index), bosses));
        }
    }
    
    public static void main (String[] args){
        GetAllBosses r = new GetAllBosses();
    }

}
