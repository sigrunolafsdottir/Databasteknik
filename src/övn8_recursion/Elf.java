package övn8_recursion;


public class Elf {
    
    private int id;
    private String name;
    private int boss;
    
    public Elf (int id, String name, int boss){
        this.id = id;
        this.name = name;
        this.boss = boss;
    }
    
    public String getName(){
        return name;
    }
    
    public int getId(){
        return id;
    }
    
    public int getBoss(){
        return boss;
    }

}
