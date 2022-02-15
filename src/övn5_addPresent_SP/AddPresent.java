package övn5_addPresent_SP;

import java.util.Scanner;

public class AddPresent {
    
    public AddPresent() throws InterruptedException{
        Repository r = new Repository();
        String present;
        String child;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("What child is getting a present?  ");
            child = sc.nextLine().trim();
            System.out.println("What will this child receive?  ");
            present = sc.nextLine().trim();
            if (present.equalsIgnoreCase("q")){
                System.exit(0);
            }
            System.out.println(r.addPresent(child, present));
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        AddPresent d = new AddPresent();
    }
}
