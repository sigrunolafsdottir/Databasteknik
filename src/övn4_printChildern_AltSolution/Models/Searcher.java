package övn4_printChildern_AltSolution.Models;

import java.util.List;

@FunctionalInterface
public interface Searcher {
    public String search(List<ChildPresentMapping> l, String s);
}
