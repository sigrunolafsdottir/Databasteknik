package övn7_nissarnas_dejtingförslagsprogram.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import övn7_nissarnas_dejtingförslagsprogram.Models.Julfest.*;
import övn7_nissarnas_dejtingförslagsprogram.Models.Nisse.*;
import övn7_nissarnas_dejtingförslagsprogram.ViewModels.*;
import övn7_nissarnas_dejtingförslagsprogram.Repository.*;


public class PartyController {
    
    JulfestRepository julfestRepo = new JulfestRepository();
    NisseRepository nisseRepo = new NisseRepository();
    
    private String getPartyAlias(DtoElf nisseAttSlåUpp, List<DtoPartyNisse> allaPartyNissar){
        List<DtoPartyNisse> allaPartyNisseNamn = 
                allaPartyNissar.stream().filter(n -> n.getName()
                        .equalsIgnoreCase(nisseAttSlåUpp.getName()))
                        .collect(Collectors.toList());
        
        if (allaPartyNisseNamn.size() > 0 ){
            return allaPartyNisseNamn.get(0).getPartyAlias();
        }
        return "Björnen Baloo";  //om fel uppstår kan nissen få bli Björnen Baloo
    }
    
    public List<NissePar> getPartyPairs(){
        
        List<DtoIntelligenceElf> intelligenceElves = nisseRepo.getAllIntelligenceElfs();
        List<DtoMakerElf> makerElves = nisseRepo.getAllMakerElfs();
        List<DtoPartyNisse> partyAliases = julfestRepo.getAllPartyNissar();
        List<NissePar> nissePar = new ArrayList<>();
        
        int lengthOfShortestElfList = 0;
        if (intelligenceElves.size() > makerElves.size()){
            lengthOfShortestElfList = makerElves.size();
        }else
        {
            lengthOfShortestElfList = intelligenceElves.size();
        }
        
        //i fas 1 av utvecklingsarbetet av denna app får tyvärr inte
        //de nissar som inte kan paras ihop  gå på festen
        //Detta är något som förhoppningsvis kommer att åtgärdas längre fram
        //eller iallafall före julfesten
  
        for (int i = 0; i < lengthOfShortestElfList; i++)
        {
            Nisse nisse1 = new Nisse(getPartyAlias(makerElves.get(i), partyAliases));
            Nisse nisse2 = new Nisse(getPartyAlias(intelligenceElves.get(i), partyAliases));
            
            nissePar.add(new NissePar(nisse1, nisse2));
        }
        
        return nissePar;
    }

}
