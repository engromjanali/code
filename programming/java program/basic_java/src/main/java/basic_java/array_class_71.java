package basic_java;

import java.util.Scanner;

public class array_class_71 {
    public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    int [] number;
    number = new int [ 11];
    int x = number.length;
    System.out.println(x);
    for ( int i =0 ; i<x; i++){
        System.out.print("enter the value of "+ (i+1)+"th number : ");
        number[i] = input.nextInt();

    }
   
    for ( int j = 0 ; j < x; j++){
        int y = number[j];
        System.out.println("the "+ (j+1)+"th number is : "+y );
}

}
} 
