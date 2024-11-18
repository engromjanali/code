package basic_java;

import java.util.Scanner;

public class matrix_part1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [][] a,b,addtion;
        a = new int[2][2];
        b = new int [2][2];
        addtion = new int [2][2];


        System.out.println("enter the element of A: ");
        for ( int row = 0; row <2; row ++){
            for ( int col = 0; col <2; col ++){
                System.out.printf("A[%d][%d] =",row,col);
                a [row][col] = input.nextInt();

            }
        }
        System.out.println("enter the element of B : ");
        for(int  row = 0 ; row < 2; row++){
            for ( int col = 0 ; col < 2 ; col ++){
                
                System.out.printf("A [%d][%d] = ", row,col);
                b [row ][ col] = input.nextInt();
                
            }
        }
        System.out.println("the element of A: ");
        for ( int row = 0; row <2; row ++){
            for ( int col = 0; col <2; col ++){
                System.out.print(" "+(a[row][col]));


            }
            System.out.println();
        }
        System.out.println("the element of B : ");
        for(int  row = 0 ; row < 2; row++){
            for ( int col = 0 ; col < 2 ; col ++){
                System.out.print(" "+(a[row][col]));

                
            }
            System.out.println();
        }
        System.out.println("the result of sumantion : ");
        for (int  row  = 0 ; row<2; row ++){
            for ( int col = 0 ; col < 2; col++){
                int resilt = addtion[row][col] = a[row][col]+b[row][col];
                System.out.print("\t"+resilt);
            }
            System.out.println();
        }

    }
}
