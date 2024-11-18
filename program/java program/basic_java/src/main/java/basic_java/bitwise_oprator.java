package basic_java;
import java.util.Scanner;

public class bitwise_oprator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, b,c;
        a = input.nextInt();
        b = input.nextInt();
        c = a | b ;
        System.out.println(" btwise or :"+ c);

        c = a ^b;
        System.out.print(" bitwise exor: " + c);

        c = a >> 5 ;
        System.out.println(" botwise shift right: "+ c);

        c = a << 4 ;
        System.out.print(" bitwise shift left : "+ c);


        
    }
}
