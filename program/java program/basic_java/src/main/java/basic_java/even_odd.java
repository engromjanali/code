package basic_java;
import java.util.Scanner ;
public class even_odd {
    public static void main(String[] args){
        int num;
        Scanner input = new Scanner (System.in);
        System.out.print("enter any positive number : ");
        num = input.nextInt();
        if (num % 2 ==0){
            System.out.print("Even");
        }

        else {
            System.out.println("Odd");
        }


    }
    
}
