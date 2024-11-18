package basic_java;

import java.util.Random;
public class rendom_number {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomnumber  = rand.nextInt(10); //for 10 genrat 0-9 # lower number defilt 0;
        int randomnumbers  = rand.nextInt(10)+1; //1 will be added with result. it's use for incrise lower number .
        System.out.println(randomnumber);
        System.out.println(randomnumbers);
        
    }
    
}
