import java.util.Scanner;

public class x {
    public static void main(String[] args) {
                Scanner inputs = new Scanner (System.in);
        String gender,gender_of_student;
        System.out.print("type \" M\" for male and type \"F\" for female:");
        gender =inputs.nextLine();
        switch (gender){

            case "m":
            gender ="male";
            break;

            case "M":
            gender ="male";
            break;

            case "f":
            gender = "female" ;
            break;

            case "F":
            gender ="female";
            break;

            default:
            System.out.println("re try");
            break;

        }
        System.out.println(gender);
 
    }
}
