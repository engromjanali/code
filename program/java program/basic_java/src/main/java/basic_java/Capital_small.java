package basic_java;
import java.util.Scanner;
public class Capital_small {


    public static void main(String [] args){
    Scanner input = new Scanner(System.in);
    char ch;
    System.out.println("enter any one charecter and hit the enter batton:");
    ch = input.next().charAt(0);

    if ( ch >= 'a' && ch <= 'z' ){
        System.out.println("small charecter.");
    }
        else if (ch <= 'Á' && ch >= 'Z' ){
        System.out .println("capital charecter.");

        }

}

}
