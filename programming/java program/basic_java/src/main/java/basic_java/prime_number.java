package basic_java;
//2,3,5,7,11,13,17,23,27,31,37,
import java.util.Scanner;
public class prime_number{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a,count ;
        System.out.println("enter any positive integer number :");
        a = input.nextInt();
        count = 0;
        for ( int i =2; i <a/2; i++){   //
            if ( a % i==0){
                count++;
                break;
            }
        }
        if ( a == 0 | a==1 ){
            System.out.println("not prime number.");

        }
        else if ( count ==0){
            System.out.println("prime number.");

        }
        else {
            System.out.println("not prime number.");
        }

    } 
}