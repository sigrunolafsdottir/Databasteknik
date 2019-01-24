package övn9_transaktioner;

import java.util.Scanner;



public class AddChild {
    
    public AddChild() throws InterruptedException{
        övn9_transaktioner.Repository r = new övn9_transaktioner.Repository();
        String child;
        String country;
        String address;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Name of child to add?");
            child = sc.nextLine().trim();
            System.out.println("Address?");
            address = sc.nextLine().trim();
            System.out.println("Country?");
            country = sc.nextLine().trim();
            if (country.equalsIgnoreCase("q") || child.equalsIgnoreCase("q")){
                System.exit(0);
            }
            r.updateChild(child, address, country);
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        AddChild d = new AddChild();
    }
}
