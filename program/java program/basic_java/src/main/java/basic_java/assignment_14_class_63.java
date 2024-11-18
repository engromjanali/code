package basic_java;

import java.util.Scanner;

public class assignment_14_class_63{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        int total_palindrome=0, reminder,fast,last, temp,i,sum;
        
        System.out.print("enter initieal numberm: ");
        fast = input.nextInt();
        
        System.out.print("enter last number : ");
        last = input.nextInt();
        for (i = fast; i<= last; i++){
            sum =0;
            temp = i;
      
            while( temp !=0){
                reminder = temp%10;
                sum = sum*10+reminder;
                temp = temp/10;
            }
            if( i == sum ){

                total_palindrome ++;
                System.out.println(sum+" ");
            }
        }
        System.out.println("total palindroome "+ total_palindrome);
    }
}