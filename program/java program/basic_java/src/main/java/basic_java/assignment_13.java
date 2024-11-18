package basic_java;
import java.util.Scanner;
public class assignment_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        System.out.print("enter which numbr you want to scc : ");
        int a ,b,c,d ,e ,f;
        a = input.nextInt();
        b = a-3;
        c =0;
        d=1;
         System.out.print(c+" "+d);
        if (a == 0){
            System.out.println("the fibo is : 0 ");
        }
        else if ( a == 1 ){
            System.out.println("the fibo is : 0 1");
        }
        for ( int i =c  ; i <= b; i++){
            e = d+c; 
            System.out.print(" "+e);

            c=d;
            d=e;

            
        }
    }
}

