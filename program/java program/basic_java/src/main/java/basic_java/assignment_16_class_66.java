package basic_java;

import java.util.Scanner;

public class assignment_16_class_66 {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String user="", passwd="",verification_user ="", verification_passwd="";
    System.out.println("CREATED BY MD ROMJAN ALI. \n HTTPS://romjanali01673.000webhostapp.com");
    int attemp = 10;
    System.out.print("enter your new  user name : ");
    user = input.next();
    System.out.print("enter your new password : ");
    passwd = input.next();

//    System.out.println("retype to confirm :       ");
    
    System.out.print("you have successfully createed a account to \"romjanali01673\".\n go to our login page to login! \n thank you. \n\n\n");

    System.out.println("welcome to our login page!");
    System.out.println("woring: the ligin attempt are limited.");
    while ( attemp >=1){
        System.out.print("enter your user name : ");
        verification_user = input.next();
        System.out.print("enter your password : ");
        verification_passwd = input.next();


        if ( user.equals(verification_user) && passwd .equals(verification_passwd)){// == are not working!
            System.out.println("you have successfully login to \"romjanali01673\"");
            break;
        }
        else{
            attemp--;
            System.out.println("there are more login attempt : "+ attemp);
        }
    }

    }
}
