/* 
switch syntax:----------
switch (expression){

*/

package basic_java;
import java.util.Scanner ;


public class  switch_31 {
    public static void main ( String [] args ){
        Scanner input = new Scanner (System.in);
        int d ;
        System.out.print("enter eny digit (0-9) :");
        d = input.nextInt();
         switch(i){
            case 0:{
                number = "zero";
                break;
            }
            case 1 :{
                number = "one";
                break;
            }
            case 2 :{
                number = "two";
                break;
            }
            case 3 :{
                number = "three";
                break;
            }
            case 4 :{
                number = "foure";
                break;
            }
            case 5 :{
                number = "five";
                break;
            }
            case 6 :{
                number = "six";
                break;
            }
            case 7 :{
                number = "seven";
                break;
            }
            case 8:
            {
                number = "eight";
                break;
            }

            default:
            {
                number = "Enter a valid number : ";
                break;
            }
        }


    }
    
}
