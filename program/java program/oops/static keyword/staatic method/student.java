public class student{
    void desplay(){
        //desplay2();// we can use static method from a non static method!
        System.out.println("i ma not static method");

    }

    static void desplay2(){
        //stataic method can't access non static method ! 
        //desplay(); # error
        System.out.println("i am static method ");

    }
}