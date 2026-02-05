package dbkurs.lambdaDemo;


import java.util.List;


public class LambdaDemo
{

    public static void main(String[] args) throws ClassNotFoundException {

        Repository repo = new Repository();
        List <Child> children = repo.getAllChildren();
       // children.forEach(c -> {c.printMe();
       //     c.printMe();});

        children.stream().filter(c -> c.getName().length() > 7).forEach(c -> c.printMe());
        children.stream().map(c -> c.getName()).forEach(c -> System.out.println(c));

        List <Elf> elfs = repo.getAllElfs();
        elfs.forEach(c -> System.out.println(c.getName()));

    }

}