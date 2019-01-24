package övn3a_nameChange;

import java.util.Scanner;

public class NameChange {
    
    public NameChange() throws InterruptedException{
        Repository r = new Repository();
        String oldElfName;
        String newElfName;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Name of elf that wants to change name?");
            oldElfName = sc.nextLine().trim();
            System.out.println("New name?");
            newElfName = sc.nextLine().trim();
            if (newElfName.equalsIgnoreCase("q") || oldElfName.equalsIgnoreCase("q")){
                System.exit(0);
            }
            System.out.println(r.updateElfName(oldElfName, newElfName));
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        NameChange d = new NameChange();
    }
}
