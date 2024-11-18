/*
how to take input from user
import java.util.Scanner;

# we have write that under of package 
 */
package basic_java;
import java.util.Scanner;

public class input_demo_class_13 {
    public static void main(String[] args){
        
        Scanner numbers = new Scanner (System.in);
        System.out.print("enter any number : ");

        
        int fast_number , fast_numbers;
        
        fast_number = numbers.nextInt();
        fast_numbers = numbers.nextInt();
        
        System.out.println("number = "+ fast_number);
        System.out.println("number = "+ fast_numbers);
        
    }   
}
