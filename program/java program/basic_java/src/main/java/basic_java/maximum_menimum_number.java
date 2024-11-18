package basic_java;

import java.util.Scanner;

public class maximum_menimum_number {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in );
        int a;
        System.out.println("enter any number 5-7 digit : ");
        a = input.nextInt();
        
        if ( a >9999999){
            System.out.println("maximun 7 number alowed. try agin...");
        }
        else if ( a <99999){
            System.out.println("memimum 5 number alowed. try agin..");
        }
        else {
            System.out.println("thank you..");
        }

        
        
    }
    
}

