
class A{
    int roll=677844;
    public void get_roll(){
        System.out.println("roll - "+roll);
    }
}
class B extends A{
    @Override
    public void get_roll(){
        System.out.println("roll No - "+roll);
    }
}
public class method_overriding {
    public static void main(String[] args) {
        A obj1 = new A();
        B obj2 = new B();
        obj1.get_roll();
        obj2.get_roll();
    }
}
