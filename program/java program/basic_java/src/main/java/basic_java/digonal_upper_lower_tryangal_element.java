package basic_java;

import java.util.Scanner;

public class digonal_upper_lower_tryangal_element {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [][] a;
        a = new int[3][3];

        
        int digonal =0, upper=0, lower=0;

        System.out.println("enter the element of A: ");
        for ( int row = 0; row <3; row ++){
            for ( int col = 0; col <3; col ++){
                System.out.printf("A[%d][%d] =",row,col);
                a [row][col] = input.nextInt();

                
            }
        }

        for ( int row = 0; row <3; row ++){
            for ( int col = 0; col <3; col ++){
                if (row==col ){

                    digonal =digonal+a[row][col];

                }
                else if (row < col){
                    upper = upper + a [ row ][col];

                }
                else {
                    lower = lower+ a[ row][col];
                }
                


            }
        }
            System.out.println(digonal+"\n"+upper+"\n"+lower);

    }
}
