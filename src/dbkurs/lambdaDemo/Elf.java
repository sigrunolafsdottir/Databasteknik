package dbkurs.lambdaDemo;


public class Elf {

    private int id;
    private String name;
    
    public Elf(int id, String name){
        this.id = id;
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void printAllNames(){
        System.out.println(name + " ");
    }
}
