package övn7_nissarnas_dejtingförslagsprogram.View;
import java.util.List;
import övn7_nissarnas_dejtingförslagsprogram.Controller.*;
import övn7_nissarnas_dejtingförslagsprogram.ViewModels.*;


public class JulfestDejtPrinter {

    PartyController pc = new PartyController();

    public List<NissePar> getPartyList(){

        return pc.getPartyPairs();
    }

    public void printPartyList(){

        getPartyList().forEach(p -> p.printPar());
    }

}
