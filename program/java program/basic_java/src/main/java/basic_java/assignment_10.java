package basic_java;

import java.util.Scanner;

public class assignment_10 {
    public static void main(String[] args) {
        
    
    Scanner input = new Scanner(System.in);
    int n ,i,sum;
    n = input.nextInt();
    sum = 0;
    for (i =0; i <=n; i++){
        sum +=i;
    }
System.out.println("result is : "+ sum);
}}
