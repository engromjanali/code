package basic_java;

import java.util.Scanner;

public class assignment_9_class_33 {
    public static void main ( String [] args ){
        Scanner input = new Scanner (System.in);
        int lang;
        String a = ("select 1 for bangla language, \n select 2 for hindi language, \n select 3 for english language, \n select 4 for hordo language,\n please select which language you want to choise :");
        System.out.print(a);
        lang = input.nextInt();
        
        switch (lang) {
            case 1:
            System.out.println(" you have selected bangla");
                break;
            case 2:
            System.out.println(" you have selected hindi");
                break;
            case 3:
            System.out.println(" you have selected eglish");
                break;
            case 4:
            System.out.println(" you have selected urdho");
                break;
            
            default:

                break;
        }


    }
    
}
