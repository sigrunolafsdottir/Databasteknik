package dbkurs.DemoSP;

import java.util.Scanner;

public class AddCountry {
    
    public AddCountry() throws InterruptedException{
        Repository r = new Repository();
        String country;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("What country would you like to add to the database?  ");
            country = sc.nextLine().trim();
            if (country.equalsIgnoreCase("q")){
                System.exit(0);
            }
            System.out.println(r.addCountry(country));
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        AddCountry d = new AddCountry();
    }
}
