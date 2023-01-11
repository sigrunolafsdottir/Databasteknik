package övn4_printChildren.Models;

import java.util.List;
import static java.util.stream.Collectors.toList;


public class Child {

    private int id;
    private String name;
    private String address;
    private Country country;
    private boolean nice;
    private List<Present> wishlist;
    private List<Present> gifts;
    
    public Child(int id, String name, String address, Country country, 
            List<Present> wishlist, List<Present> gifts, boolean nice){
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.wishlist = wishlist;
        this.gifts = gifts;
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
    
    public List<Present> getWishlist(){
        return wishlist;
    }
    
    public void setWishlist(List<Present> wishlist){
        this.wishlist = wishlist;
    }
    
    public List<Present> getGifts(){
        return gifts;
    }
    
    public void setGifts(List<Present> gifts){
        this.gifts = gifts;
    }

    public void addGift(Present gift){
        gifts.add(gift);
    }
    public void addWish(Present wish){
        wishlist.add(wish);
    }
    
    public void print(){
        System.out.println(name+" "+address+" "+country.getName()+" "+nice);
        System.out.println("Wishes: " +  wishlist.stream()
                .map(Present::getName).collect(toList()));
        System.out.println("Gifts: " + gifts.stream()
                .map(Present::getName).collect(toList()));
    }
}
