package basic_java;
import java.util.Scanner;
public class temperature_class_19 {
    public static void main(String [] args){
        Scanner input = new Scanner ( System.in);
        double cel , fahr;
        System.out.print("enter the temperature in celsius : ");
        cel = input.nextDouble();
        fahr = (cel*1.8)+32;

        System.out.printf("temperature in fahrenheit : %.2f", fahr);

    }
    
}