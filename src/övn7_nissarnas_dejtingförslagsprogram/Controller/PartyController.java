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
        System.out.println("problem "+ nisseAttSlåUpp.getName());
        return "Björnen Baloo";  //om fel uppstår kan nissen få bli Björnen Baloo
    }
    
    public List<NissePar> getPartyPairs(){
        
        List<DtoIntelligenceElf> intelligenceElves = nisseRepo.getAllIntelligenceElfs();
        List<DtoMakerElf> makerElves = nisseRepo.getAllMakerElfs();
        List<DtoBossElf> bossElves = nisseRepo.getAllBossElfs();
        List<DtoPartyNisse> partyAliases = julfestRepo.getAllPartyNissar();
        List<NissePar> nissePar = new ArrayList<>();
        
        // eftersom jag vet att det är typ dubbelt så många makerelfs mot de andra
        List <DtoElf> intelligenceAndBossElves = new ArrayList<>();
        intelligenceAndBossElves.addAll(intelligenceElves);
        intelligenceAndBossElves.addAll(bossElves);

        int lengthOfShortestElfList = 0;
        if (intelligenceAndBossElves.size() > makerElves.size()){
            lengthOfShortestElfList = makerElves.size();
        }else
        {
            lengthOfShortestElfList = intelligenceAndBossElves.size();
        }

        //Om listorna blir olika långa kommer någar att hamna utanför och inte få gå på festen

        for (int i = 0; i < lengthOfShortestElfList; i++)
        {
            Nisse nisse1 = new Nisse(getPartyAlias(makerElves.get(i), partyAliases));
            Nisse nisse2 = new Nisse(getPartyAlias(intelligenceAndBossElves.get(i), partyAliases));
            
            nissePar.add(new NissePar(nisse1, nisse2));
        }
        
        return nissePar;
    }

}
