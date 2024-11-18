/*
  larg = (num1 > num2) ? num1 (true) : num2 (false);
*/
package basic_java;

import java.util.Scanner;

public class conditonal_oprator {
    public static void main(String[] args ){

    Scanner input = new Scanner(System.in);
    
    int num2 , num1, larg ;
    System.out.print("enter two number: ");

    num1 = input.nextInt();
    num2 = input.nextInt();

    larg = (num1 > num2) ? num1 : num2;
    System.out.print(" larg number is "+ larg);
    }
}
