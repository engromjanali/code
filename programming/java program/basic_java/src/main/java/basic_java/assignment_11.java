package basic_java;

import java.util.Scanner;

public class assignment_11 {
    
    public static void main(String[] args) {
        Scanner input= new Scanner (System.in);

        int n ,i ,fact ;
        System.out.print("enter the number : ");
        n = input.nextInt();
        fact = 1;
        for ( i = 1 ; i <= n ; i ++){
            fact = fact *i;

        }
        System.out.println("the facturial is : "+ fact);

    }
}
