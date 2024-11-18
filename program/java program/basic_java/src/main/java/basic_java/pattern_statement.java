/*
 * 1
 * 1 2 
 * 1 2 3 
 * 1 2 3 4 
 * 1 2 3 4 5
 */

//package basic_java;
//
//import java.util.Scanner;
//
//public class pattern_statement{
//    public static void main( String [] args){
//        Scanner input = new Scanner(System.in);
//        int  n ;
//        System.out.println("enter line number : ");
//        n = input .nextInt();
//        for (int  row = 1 ; row <=n; row ++){
//            for ( int col = 1 ;  col <=row; col++){
//                System.out.print(" "+col);
//            }
//            System.out.println("");
//        }        
//    }
//}

/*

  *
  * *
  * * *
  * * * *
  * * * * *

 */

//package basic_java;
//
//import java.util.Scanner;
//
//public class pattern_statement{
//    public static void main( String [] args){
//        Scanner input = new Scanner(System.in);
//        int  n ;
//        System.out.println("enter line number : ");
//        n = input .nextInt();
//        for (int  row = 1 ; row <=n; row ++){
//            for ( int col = 1 ;  col <=row; col++){
//                System.out.print(" "+"*");
//            }
//            System.out.println("");
//        }        
//    }
//}



/*
 1
 2 2
 3 3 3
 4 4 4 4
 5 5 5 5 5
 */


/*
package basic_java;

import java.util.Scanner;

public class pattern_statement{
    public static void main( String [] args){
        Scanner input = new Scanner(System.in);
        int  n ;
        System.out.println("enter line number : ");
        n = input .nextInt();
        for (int  row = 1 ; row <=n; row ++){
            for ( int col = 1 ;  col <=row; col++){
                System.out.print(" "+row);
            }
            System.out.println("");
        }        
    }
}
*/



/*
 * 1 2 3 4 5
 * 1 2 3 4
 * 1 2 3
 * 1 2
 * 1
 */

package basic_java;

import java.util.Scanner;

public class pattern_statement{
    public static void main( String [] args){
        Scanner input = new Scanner(System.in);
        int  n ;
        System.out.println("enter line number : ");
        n = input .nextInt();
        for (int  row = n ; row >=1; row --){
            for ( int col = 1 ;  col <=row; col++){
                System.out.print(" "+col);
            }
            System.out.println("");
        }        
    }
}

