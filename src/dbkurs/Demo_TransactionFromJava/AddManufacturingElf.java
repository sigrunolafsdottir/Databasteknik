package dbkurs.Demo_TransactionFromJava;

import java.util.Scanner;

public class AddManufacturingElf {
    
    public AddManufacturingElf() throws InterruptedException{
        Repository r = new Repository();
        String elfname;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("What elf would you like to add to the database?  ");
            elfname = sc.nextLine().trim();
            if (elfname.equalsIgnoreCase("q")){
                System.exit(0);
            }
            System.out.println(r.addManufacturingElf(elfname));
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        AddManufacturingElf d = new AddManufacturingElf();
    }
}
