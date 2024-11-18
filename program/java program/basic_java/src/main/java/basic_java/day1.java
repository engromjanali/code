package basic_java;

import java.util.Scanner;

public class day1 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int a ,b ;
        System.out.print("enter initial number : ");
        a = input.nextInt();
        System.out.print("enter ending number : ");
        b = input.nextInt();
        int count = 0 ;
        if ( a ==0| a==1){
            a =2;
            }

        for (int  i = a; i <=b; i ++){
            for (int j =2 ; j<=i/2; j++){
                if ( i%j==0){
                    count ++;
                    break;
                }
            }
            if (count ==0)
            System.out.println(i);
            count=0;
        }   
        }

    }
    