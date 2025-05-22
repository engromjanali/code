package basic_java;
import java.util.Scanner;

public class assignment_06 {
    public static void main ( String [] args ){
        int d ;
        Scanner input = new Scanner(System.in) ;
        System.out.print(" press any degite between 0-9: " );

        d = input.nextInt();
        if (d >=0){
            if (d <=9){
                if ( d == 0){
                    System.out.println(" the digit spelling is : \"zero\" ");
                }
                else if ( d == 1){
                    System.out.println(" the digit spelling is : \"zero\" ");
                }
                else if ( d == 2 ){
                    System.out.println(" the digit spelling is : \"two\" ");
                }
                else  if ( d == 3){
                    System.out.println(" the digit spelling is : \"three\" ");

                }
                else if ( d == 4 ){
                    System.out.println(" the digit spelling is : \"four\" ");
                }
                else if ( d == 5 ){
                    System.out.println(" the digit spelling is : \"five\" ");

                }
                else if ( d == 6 ){
                    System.out.println(" the digit spelling is : \"six\" ");
                }
                else if ( d == 7 ){
                    System.out.println(" the digit spelling is : \"seven\" ");
                } 
                else if ( d == 8 ){
                    System.out.println(" the digit spelling is : \"eight\" ");
                } 
                else if ( d == 9 ){
                    System.out.println(" the digit spelling is : \"nine\" ");
                } 
            }
              
            else {
                System.out.println("enter a valid value : ");
            }
        }
        else {
            System.out.println("you have press a wrong value.");
        }
                
    }
}


    
    

