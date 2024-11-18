package basic_java;

import java.util.Arrays;

public class array_sorting {
    public static void main(String[] args) {
        int [] number =  {12,3,3,2,15,5557 };
        //System.out.println(number.length);
        Arrays.sort(number);
        System.out.println("ascending number : ");
        for (int  i =0; i < number.length;i++){
            System.out.print(" "+number[i]);

        }

        System.out.println("\nthe descending number : ");
        for (int j = (number.length-1) ; j>=0; j--){
            System.out.print(" "+number[j]);
        }

        System.out.println();
        String [] name = { "romjan","sakib","siam",  "kupil", "jahid","sayed","arafat"};
        int x = name.length;
        Arrays.sort(name);
        for ( int n = 0 ; n<x; n++){
            System.out.println(" "+ name[n]);

        }
    }
}
