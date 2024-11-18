/*if sintex:

if (condition) {
    stetment
}

elif if (condition) {
    stetment
}

else {
    stetment
}
 */
package basic_java;
import java.util.Scanner ;
public class control_statement_class_22{
    public static void main (String [] args){
        int a , b,c ;
        Scanner input = new Scanner (System.in);
        System.out.println("enter the value of a : " );
        a = input.nextInt();
        System.out.println("enter the value of b : " );
        b = input.nextInt();
        System.out.println("enter the value of c : " );
        c = input.nextInt();
        if ( a < c && c> b ){
            System.out.println("c is largest." );
        }
        else if (a >c && a>b ){
            System.out.println("a is largest number." );
        }
        else {
            System.out.println("b is largest number." );
        }
        }

    }
     













