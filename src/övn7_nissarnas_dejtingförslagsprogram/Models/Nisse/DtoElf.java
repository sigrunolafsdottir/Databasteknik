package övn7_nissarnas_dejtingförslagsprogram.Models.Nisse;

//Dto står för Data Transfer Object
public abstract class DtoElf {
    private String name;
    
    public DtoElf (String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}
