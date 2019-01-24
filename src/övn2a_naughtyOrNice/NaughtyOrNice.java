package övn2a_naughtyOrNice;

import java.util.Scanner;


public class NaughtyOrNice {
    
    public NaughtyOrNice() throws InterruptedException{
        Repository r = new Repository();
        String name;
        Scanner sc = new Scanner(System.in);
        
        while(true){
            System.out.println("Name of child: ");
            name = sc.nextLine().trim();
            r.getChildByName(name).printOut();

        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        NaughtyOrNice d = new NaughtyOrNice();
    }

}
