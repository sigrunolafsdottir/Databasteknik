package övn4_printChildern_AltSolution;

import com.sun.tools.javac.Main;
import övn4_printChildern_AltSolution.Models.ChildPresentMapping;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainProgram {

    final Repository r = new Repository();
    final List<ChildPresentMapping> wishes = r.getAllWishes();
    final List<ChildPresentMapping> gifts = r.getAllGifts();
    final Scanner sc = new Scanner(System.in);

    String getChildList(List<ChildPresentMapping> l, String child){
        return l.stream().filter(x -> x.getChild().getName().equalsIgnoreCase(child))
                .map(y -> y.getPresent().getName()).collect(Collectors.joining(", "));
    }

    String getPresentList(List<ChildPresentMapping> l, String present){
        return l.stream().filter(x -> x.getPresent().getName().equalsIgnoreCase(present))
                .map(y -> y.getChild().getName()).collect(Collectors.joining(", "));
    }

    public MainProgram(){

        while(true) {
            System.out.println("Vilket barn vill du se önskningar och gåvor för?");
            String child = sc.next();

            System.out.println("Önskningar: " + getChildList(wishes, child));
            System.out.println("Gåvor: " + getChildList(gifts, child));

            System.out.println("Vilken present vill du se hur den önskats eller givits?");
            String present = sc.next();

            System.out.println("Önskningar: " + getPresentList(wishes, present));
            System.out.println("Gåvor: " + getPresentList(gifts, present));
        }
    }

    public static void main(String[] args) {
        MainProgram m = new MainProgram();
    }
}
