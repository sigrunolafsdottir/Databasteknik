package övn7_nissarnas_dejtingförslagsprogram.Models.Nisse;

//Dto står för Data Transfer Object
public class DtoIntelligenceElf extends DtoElf {

    private int securityLevel;
    
    public DtoIntelligenceElf (String name, int securityLevel){
        super(name);
        this.securityLevel = securityLevel;
    }
    
    public int getSecurityLevel(){
        return securityLevel;
    }
}
