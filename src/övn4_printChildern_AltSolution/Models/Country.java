package övn4_printChildern_AltSolution.Models;

public class Country {

    private int id;
    private String name;
    
    public Country(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Country(){}
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

}
