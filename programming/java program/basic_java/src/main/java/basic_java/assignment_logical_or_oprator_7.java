package basic_java;

import java.util.Scanner;

public class assignment_logical_or_oprator_7 {
    public static void main(String [] args){

        Scanner input = new Scanner(System.in);
        System.out.print("do you love java? ans by (YES / NO) : ");
        char ans;
        ans = input.next().charAt(0);
        if (ans == 'y' || ans =='Y'){
            System.out.println("You are a java lover.");
        }
        else if (ans == 'n' || ans =='N') {
            System.out.println("You are not a java lover!");
        }
        else {
            System.out.println("put rigjht ans!");
        }



    }
}
