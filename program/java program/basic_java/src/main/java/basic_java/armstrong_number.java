package basic_java;

import java.util.Scanner;

public class armstrong_number {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int fast ,last, number, temp,k=0;
        System.out.println("enter initieal number : ");
        fast = input.nextInt();
        System.out.println("enter last number : ");
        last = input.nextInt();
        for ( int i = fast; i <= last; i++){
            temp = i ;
            int sum = 0;
            while (temp!=0 ){
                number = temp % 10;
                sum = sum +( number * number * number);
                temp = temp / 10 ;
            }
            if ( sum == i){
                System.out.println ("the armstrong number is : "+ sum );
                k++;

            }
        }
        System.out.println("total number is : " + k);
        
    }
}
