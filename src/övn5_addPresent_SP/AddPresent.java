package övn5_addPresent_SP;

import java.util.Scanner;

public class AddPresent {
    
    public AddPresent() throws InterruptedException{
        Repository r = new Repository();
        String present;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("What present would you like to add to the database?  ");
            present = sc.nextLine().trim();
            if (present.equalsIgnoreCase("q")){
                System.exit(0);
            }
            System.out.println(r.addPresent(present));
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        AddPresent d = new AddPresent();
    }
}
