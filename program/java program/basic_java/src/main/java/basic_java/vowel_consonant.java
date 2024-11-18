package basic_java;
import java.util.Scanner;
public class vowel_consonant {
    public static void main ( String [] args ){
        Scanner input = new Scanner ( System.in);
        char ch;
        System.out.print("enter any letter : ");
        ch = input.next().charAt(0);//onle one charecter taken.

        if (ch == 'a'){
            System.out.println("vowel"); 
        }

        else if (ch == 'i'){
            System.out.println("vowel"); 
        }
        else if (ch == 'e'){
            System.out.println("vowel"); 
        }
        else if (ch == 'o'){
            System.out.println("vowel"); 
        }
        else if (ch == 'u'){
            System.out.println("vowel"); 
        }

        else {
            System.out.println("consonant"); 
        }
    }
    
}
