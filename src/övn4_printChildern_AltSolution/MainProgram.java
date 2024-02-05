package övn4_printChildern_AltSolution;

import com.sun.tools.javac.Main;
import övn4_printChildern_AltSolution.Models.ChildPresentMapping;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainProgram {

    String getList(List<ChildPresentMapping> l, String child){
        return l.stream().filter(x -> x.getChild().getName().equalsIgnoreCase(child))
                .map(y -> y.getPresent().getName()).collect(Collectors.joining(", "));
    }

    public MainProgram(){
        Repository r = new Repository();
        List<ChildPresentMapping> wishes = r.getAllWishes();
        List<ChildPresentMapping> gifts = r.getAllGifts();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("Vilket barn vill du se önskningar och gåvor för?");
            String child = sc.next();

            System.out.println("Önskningar: " + getList(wishes, child));
            System.out.println("Gåvor: " + getList(gifts, child));
        }
    }

    public static void main(String[] args) {
        MainProgram m = new MainProgram();
    }
}
