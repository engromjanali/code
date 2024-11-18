package basic_java;

import java.util.Scanner;

public class reverse {
    public static void main(String[] args) {
        Scanner input = new Scanner ( System.in );
        int n ,sum,r,temp;
        n = input.nextInt();
        temp = n ;
        sum = 0;
        while ( temp !=0){
            r = temp%10;
            sum=sum* 10 + r;
            temp = temp/10;

        }
        System.out.println(sum);


    }
}
