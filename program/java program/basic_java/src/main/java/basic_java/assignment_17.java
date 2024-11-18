/*
 * 1
 * 0 0
 * 1 1 1
 * 0 0 0 0
 * 1 1 1 1 1
 * 0 0 0 0 0 0
 
package basic_java;

import java.util.Scanner;

public class assignment_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the line number : ");
        int n;
        n = input.nextInt();
        for ( int i =1; i<= n ; i ++){
            for ( int j = 1 ; j<=i; j++){
                if ( i%2 == 1){
                System.out.print(1);
                }
                else{
                    System.out.print(0);
                }
        }
        System.out.println("");
    }

        
    }
}
*/


/*
 * 1
 * 1 0
 * 1 0 1
 * 1 0 1 0
 * 1 0 1 0 1
package basic_java;

import java.util.Scanner;

public class assignment_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("enter the line number : ");
        int n;
        n = input.nextInt();
        for ( int i =1; i<= n ; i ++){
            for ( int j = 1 ; j<=i; j++){

            System.out.print(" "+j%2);
        }
        System.out.println("");
    }

        
    }
}
 */



