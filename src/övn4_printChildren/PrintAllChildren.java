package övn4_printChildren;

import java.util.List;
import java.util.Map;

import övn4_printChildren.Models.Child;


public class PrintAllChildren {
    
    public static void main (String args[]){
        Repository r = new Repository();
        List<Child> l = r.getAllChildren();
        l.forEach(c -> c.print());

        /*
        System.out.println(" ");
        MapRepo ar = new MapRepo();
        Map<Integer, Child> cMap = ar.getAllChildren();
        cMap.forEach((k,v) -> v.print());
*/
        //Map, exempel
        //[ (45, {childobj1}), (123, {childobj2}), osv osv ]

    }

}
