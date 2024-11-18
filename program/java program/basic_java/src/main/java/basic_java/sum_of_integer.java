/*
# write a program that read any positive integer and display sum of  digit !----------

12314325
will be : 1+2+3+1+4+3+2+5
*/
package basic_java;

import java.util.Scanner;

public class sum_of_integer {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n ,temp ,r,sum ;
        System.out.println("enter a integer: ");
        n = input.nextInt();
        temp = n ;
        sum = 0 ;
        while ( temp != 0){
            r = temp%10;
            sum = sum+r;
            temp = temp/10;
        }
        System.out.println(sum);



    }
}
