package övn7_nissarnas_dejtingförslagsprogram.ViewModels;


public class Nisse {

    private String partyAlias;
    
    public Nisse(String partyAlias){
        this.partyAlias = partyAlias;
    }
    
    public String getPartyAlias(){
        return partyAlias;
    }
    
    public void setPartyAlias(String partyAlias){
        this.partyAlias = partyAlias;
    }
}
