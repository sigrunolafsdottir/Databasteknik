package övn2b_naughtyOrNice;


public class Child {

    private int id;
    private String name;
    private boolean nice;
    
    public Child(int id, String name, boolean nice){
        this.id = id;
        this.name = name;
        this.nice = nice;
    }
    
    public Child(){}
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public boolean getNice(){
        return nice;
    }

    public void printOut(){
        System.out.println(this.name + " is " + (nice ? "Nice" : "Naughty"));
    }
}
