package övn7_nissarnas_dejtingförslagsprogram.Models.Julfest;

//Dto står för Data Transfer Object
public class DtoPartyNisse {
    
    private String name;
    private String partyAlias;
    
    public DtoPartyNisse (String name, String partyAlias){
        this.name = name;
        this.partyAlias = partyAlias;
    }
    
    public String getPartyAlias(){
        return partyAlias;
    }
    
    public void setPartyAlias(String partyAlias){
        this.partyAlias = partyAlias;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

}
