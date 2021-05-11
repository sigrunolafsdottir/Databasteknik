package dbkurs;


public class Customer {
    private String name;
    private int id;
    private String city;

    public Customer() {};

    public Customer(int id, String name, String city){
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void printMe(){
        System.out.println("Id: "+ id +" Name: "+name+" City "+city);
    }

}