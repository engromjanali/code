package basic_java;

import java.util.Scanner;

public class assignment_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in );
        String [] weekdays = { "saterday" , "sunday", "monday ", "theusday", "wednesday", "thuesday","friday"};
        System.out.println("enter the day number ( 1-7)  : ");
        int x = input.nextInt();
        System.out.println("the days name is : " + weekdays[x-1] );
    }
}
