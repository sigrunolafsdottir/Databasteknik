package övn7_nissarnas_dejtingförslagsprogram.View;
import java.util.List;
import övn7_nissarnas_dejtingförslagsprogram.Controller.*;
import övn7_nissarnas_dejtingförslagsprogram.ViewModels.*;


public class JulfestDejtPrinter {

    public JulfestDejtPrinter() {
        
        PartyController pc = new PartyController();
        List<NissePar> np = pc.getPartyPairs();
        np.forEach(p -> p.printPar());
        
    }
}
