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
            try{
                r.getChildByName(name).printOut();
            }
            catch (NullPointerException e){
                System.out.println(name +"does not exist in the databse");
            }

        }
    }
    
    public static void main(String args[]) throws InterruptedException {
        NaughtyOrNice2b d = new NaughtyOrNice2b();
    }

}
