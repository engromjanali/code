package basic_java;
import java.util.Scanner;

public class assignment_03 {
    public static void main(String []  args){
        Scanner input  = new Scanner (System.in);
        int id, price;
        String title, description, category;
        System.out.print("write the id number :"); 
        id = input.nextInt();
        System.out.print("write the name of title :"); 
        title = input.next();
        System.out.print("write the price of priduct :"); 
        price = input.nextInt();
        System.out.print("write the description :"); 
        description = input.next();
        System.out.print("write the catagory:"); 
        category = input.next();
        
        System.out.println("id = "+ id);
        System.out.println("Price = "+price);
        System.out.println("catefory  ="+ category);
        System.out.println("title ="+ title);
        System.out.println("description = "+ description);
        

        
    }
}
