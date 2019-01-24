package övn6_addManufacturingElf;

import java.util.Scanner;

public class AddManufacturingElf {
    
    public AddManufacturingElf() throws InterruptedException{
        Repository r = new Repository();
        String elfName;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("What elf would you like to add to the database?  ");
            elfName = sc.nextLine().trim();
            if (elfName.equalsIgnoreCase("q")){
                System.exit(0);
            }
            System.out.println(r.addManufacturingElf(elfName));
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        AddManufacturingElf d = new AddManufacturingElf();
    }
}
