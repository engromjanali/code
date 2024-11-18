package basic_java;

import java.util.Scanner;

public class palindrome_number {
    public static void main (String[] args){
    Scanner input = new Scanner(System.in);
    int temp, number,reminder,sum = 0;
    System.out.print("enter a number: ");
    number = input.nextInt();
    temp = number;
    while (temp != 0){
        reminder = temp%10;
        sum = (sum *10)+reminder;
        temp = temp /10;
    }
    if( number == sum){
        System.out.println(sum +"\n palindrome number!"); 
    }
    }
}
