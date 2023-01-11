package övn4_printChildren;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import övn4_printChildren.Models.Child;
import övn4_printChildren.Models.Present;


public class PrintAllChildren {
    
    public static void main (String args[]){
        Repository r = new Repository();
        List<Child> l = r.getAllChildren();
        l.forEach(c -> c.print());

        System.out.println(" ");
        AlternativeSolutionRepo ar = new AlternativeSolutionRepo();
        Map<Integer, Child> cMap = ar.getAllChildren();
        cMap.forEach((k,v) -> v.print());

    }

}
