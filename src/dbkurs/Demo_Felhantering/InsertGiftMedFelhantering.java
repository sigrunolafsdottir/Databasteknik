package dbkurs.Demo_Felhantering;

import java.util.Scanner;

public class InsertGiftMedFelhantering {
    
    public InsertGiftMedFelhantering() throws InterruptedException{
        Repository r = new Repository();
        String child;
        String present;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("ViLket barn ska få en present?  ");
            child = sc.nextLine().trim();
            System.out.println("Vad ska barnet få?  ");
            present = sc.nextLine().trim();
            if (child.equalsIgnoreCase("q")){
                System.exit(0);
            }
            System.out.println(r.addManufacturingElf(child, present));
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        InsertGiftMedFelhantering d = new InsertGiftMedFelhantering();
    }
}
