package övn4_printChildren.Models;

public class Present {

    private int id;
    private String name;
    
    public Present(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public Present(){}
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }

}
