package övn8_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class GetAllUnderlings {
    
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
    
    public List<String> getAllUnderlings(Elf elfToCheck, List<String> underlings){     
        List <Elf> tempUnderlings = elfs.stream()
                .filter(e -> e.getBoss() 
                        == elfToCheck.getId())
                .collect(Collectors.toList());
        for(Elf e : tempUnderlings){
            underlings.add(e.getName());
            getAllUnderlings(e, underlings);
        }
        return underlings;  
    }

    
    public GetAllUnderlings () {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Get all underlings for what index in elf list:");
            index = sc.nextInt();
            List<String> underlings = new ArrayList<>();
            System.out.println(getAllUnderlings(elfs.get(index), underlings));
        }
    }
    
    public static void main (String[] args){
        GetAllUnderlings r = new GetAllUnderlings();
    }

}
