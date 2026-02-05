package övn4_printChildern_AltSolution;

import övn4_printChildern_AltSolution.Models.ChildPresentMapping;
import övn4_printChildern_AltSolution.Models.Searcher;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainProgramHigherOrderFunctions {

    final Repository r = new Repository();
    final List<ChildPresentMapping> wishes = r.getAllWishes();
    final List<ChildPresentMapping> gifts = r.getAllGifts();
    final Scanner sc = new Scanner(System.in);

    Searcher findPresentsForChild = (l, child) -> l.stream().filter(x -> x.getChild().getName()
                    .equalsIgnoreCase(child))
            .map(y -> y.getPresent().getName()).collect(Collectors.joining(", "));

    Searcher findChildrenForPresent = (l, present) -> l.stream().filter(x -> x.getPresent().getName()
                    .equalsIgnoreCase(present))
            .map(y -> y.getChild().getName()).collect(Collectors.joining(", "));



    public String doSearch(Searcher searcher, List<ChildPresentMapping> l, String s){
        return searcher.search(l, s);
    }


    public MainProgramHigherOrderFunctions(){

        while(true) {
            System.out.println("Vilket barn vill du se önskningar och gåvor för?");
            String child = sc.next();

            System.out.println("Önskningar: " + doSearch(findPresentsForChild, wishes, child));
            System.out.println("Gåvor: " + doSearch(findPresentsForChild, gifts, child));

            System.out.println("Vilken present vill du se hur den önskats eller givits?");
            String present = sc.next();

            System.out.println("Önskningar: " + doSearch(findChildrenForPresent, wishes, present));
            System.out.println("Gåvor: " + doSearch(findChildrenForPresent, gifts, present));
        }
    }

    public static void main(String[] args) {
        MainProgramHigherOrderFunctions m = new MainProgramHigherOrderFunctions();
    }
}
