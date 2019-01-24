package övn3c_addPresent;

import java.util.Scanner;

public class AddPresent {
    
    public AddPresent() throws InterruptedException{
        Repository r = new Repository();
        String prensetName;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Name of present to add?");
            prensetName = sc.nextLine().trim();
            if (prensetName.equalsIgnoreCase("q")){
                System.exit(0);
            }
            System.out.println(r.addPresent(prensetName));
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        AddPresent d = new AddPresent();
    }
}
