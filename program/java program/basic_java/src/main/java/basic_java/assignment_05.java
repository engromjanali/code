package basic_java;
import java.util.Scanner;

public class assignment_05 {
    public static void main ( String [] args){
        Scanner input = new Scanner (System.in);
        int age;
        System.out.print("how old are you? : ");

        age = input.nextInt();

        if (age > 18) {
            System.out.print("you are a valid voter.");

        }
        else {
            System.out.println("you are not a valid voter.");
        }
    }
    
}
