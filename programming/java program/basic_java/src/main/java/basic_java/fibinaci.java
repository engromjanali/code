package basic_java;

import java.util.Scanner;

public class fibinaci {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,a,b,c,i, m;
        n= input.nextInt();
        m = n-3;
        a = 0;
        b = 1;
        System.out.print(a);
        for ( i = a; i<= m; i++){
            c = a+b;
            System.out.print(" "+c);
            
            b=a;
	    a=c;
        }


    }
}
