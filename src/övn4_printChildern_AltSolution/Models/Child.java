package övn4_printChildern_AltSolution.Models;

import java.util.List;

import static java.util.stream.Collectors.toList;


public class Child {

    private int id;
    private String name;
    private String address;
    private Country country;
    private boolean nice;
    
    public Child(int id, String name, String address, Country country, boolean nice){
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.nice = nice;
    }
    
    public Child(){}

    public Child(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String name){
        this.address = address;
    }
    
    public Country getCountry(){
        return country;
    }
    
    public void setCountry(Country country){
        this.country = country;
    }
    
    public boolean getNice(){
        return nice;
    }
    
    public void setNice(boolean nice){
        this.nice = nice;
    }

    
    public void print(){
        System.out.println(name+" "+address+" "+country.getName()+" "+nice);
    }
}
