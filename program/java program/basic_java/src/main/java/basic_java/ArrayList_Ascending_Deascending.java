package basic_java;
import java.util.ArrayList;
import java.util.Collections;


public class ArrayList_Ascending_Deascending {
    

    public static void main(String[] args) {

        ArrayList<Integer>number1 = new ArrayList<>();
       

        number1.add(1);
        number1.add(2);
        number1.add(3);
        number1.add(4);
        number1.add(5);
        number1.add(6);
        number1.add(7);  
        
        System.out.println("number 1 :");
        System.out.println(number1);

        Collections.sort(number1);
        System.out.println("number 1 as ascending : "+number1);

 
        Collections.sort(number1,Collections.reverseOrder());
        System.out.println("number 1 as deascending : "+ number1);
        
    }
}
