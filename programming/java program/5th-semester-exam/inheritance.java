class student{
    String name;
    int age;
    void display1(){
        System.out.println(name);
        System.out.println(age);
    }
}
class techer extends student{
    String qualification;
    void display2() {
        display1();
        System.out.println(qualification);
    };
}

public class inheritance {
    
}
