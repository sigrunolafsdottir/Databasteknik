package dbkurs;


public class Child {
    private String name;
    private int id;
    private String address;

    public Child() {};

    public Child(int id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void printMe(){
        System.out.println("Id: "+ id +" Name: "+name+" Address "+address);
    }

}