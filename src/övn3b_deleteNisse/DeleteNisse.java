package övn3b_deleteNisse;

import java.util.Scanner;

public class DeleteNisse {
    
    public DeleteNisse() throws InterruptedException{
        Repository r = new Repository();
        String elfName;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Name of elf to delete?");
            elfName = sc.nextLine().trim();
            if (elfName.equalsIgnoreCase("q")){
                System.exit(0);
            }
            System.out.println(r.deleteElf(elfName));
        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        DeleteNisse d = new DeleteNisse();
    }
}
