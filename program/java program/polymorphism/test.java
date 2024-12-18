/*
    amra parent/supper class "person" er maddoma child/sub class access korta partace aita ka e amra polymorphism vole.
  */

public class test{
    public static void main(String [] args){
        // polymorphism 
        person p = new person();
        student s = new student();
        teachers t = new teachers();

        p.Display();
        s.Display();
        t.Display();

        /*
        // polymorphism with dynamic method despose.
        person p = new person();
        p.Display();

        p = new student();
        p.Display();

        p = new teachers();
        p.Display();
         */


    }    
}
