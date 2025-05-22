class A {
    String name ;
     A(String name){
        this.name = name;
    }
     void display(){
        System.out.println(name);
    }
}

public class object_reference_variable{
    public static void main(String[] args) {
        A as = new A("romjan");
        as.display();
        A asd = as;
        asd.display();
    }
}
