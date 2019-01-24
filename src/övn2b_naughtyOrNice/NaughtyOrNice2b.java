package övn2b_naughtyOrNice;

import java.util.Scanner;


public class NaughtyOrNice2b {
    
    public NaughtyOrNice2b() throws InterruptedException{
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
        NaughtyOrNice2b d = new NaughtyOrNice2b();
    }

}
