/*
package basic_java;

import java.util.Scanner;

public class time_table {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a , b,c ;
        System.out.println("enter the fast number : ");
        a = input.nextInt();
        System.out.println("enter the value of last number : ");
        c = input.nextInt();
        for(int i =1; i <=10; i ++){
            b = a *i;
            if( a == c+1 ){
                System.out.print("thank you!");
                break;}
            System.out.println(a +" x "+i+" = "+b );

            
            if (i == 10){
                i = 0;
                a ++;
                System.out.println("\n \n");
            }


            }
        }
    }
*/
package basic_java;

import java.util.Scanner;

public class time_table {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a , b,c ;
        System.out.println("enter the fast number : ");
        a = input.nextInt();
        System.out.println("enter the value of last number : ");
        c = input.nextInt();
        for(int i =a; i <=c; i ++){
            System.out.println("\n\n");
            for (int  j = 1 ; j <=10; j++){
                b =j*i;
                System.out.println(i +" x "+j+" = "+ b );
            }
        }
        }
    }


