package övn4_printChildren;

import java.util.List;
import övn4_printChildren.Models.Child;


public class PrintAllChildren {
    
    public static void main (String args[]){
        Repository r = new Repository();
        r.getAllChildren().forEach(c -> c.print());

        System.out.println(" ");
        AlternativeSolutionRepo ar = new AlternativeSolutionRepo();
        ar.getAllChildren().forEach((k,v) -> v.print());
    }

}
