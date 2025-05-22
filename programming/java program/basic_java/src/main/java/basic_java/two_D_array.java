/*
package basic_java;

import java.util.Scanner;

public class two_D_array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [][] matrix = new int [3][3];

        matrix [0][0] = 10;
        matrix [0][1] = 34;
        matrix [0][2] = 33;
        matrix [1][0] = 76;
        matrix [1][1] = 66;
        matrix [1][2] = 43;
        matrix [2][0] = 43;
        matrix [2][1] = 22;
        matrix [2][2] = 40;

        System.out.println(matrix [0][0]);
        System.out.println(matrix [0][1]);
        System.out.println(matrix [0][2]);
        System.out.println(matrix [1][0]);
        System.out.println(matrix [1][1]);
        System.out.println(matrix [1][2]);
        System.out.println(matrix [2][0]);
        System.out.println(matrix [2][1]);
        System.out.println(matrix [2][2]);
        

        

    }
    
}

 */


 
/*
package basic_java;

import java.util.Scanner;

public class two_D_array {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r , c;
        System.out.println("enter the value of row : ");
        r = input .nextInt();
        System.out.println("enter the value of column : ");
        c= input.nextInt();
        int [][] matrix = new int [r][c];


        for ( int row= 0; row <r; row++){
            for(int col =0; col <c; col ++){

                matrix [row][col] = input.nextInt();
  

            }
        }
  


        for ( int row = 0; row <r; row++){
            for ( int col = 0 ; col < c; col++){
                System.out.print(" "+matrix[row][col]);
            }
            System.out.println();
        }
    }
}
*/
/*
public class two_D_array {
     public static void main(String[] args) {
        int [][]arr1 = {{10,20,30},{40,50,60}};
        int [][]arr2 = {{70,80,90},{100,110,120}};
        int[][]sum=new int[2][3];
        System.out.println(arr1[0].length);

        for(int row=0; row<arr1.length;row++){
            for(int col=0; col<arr1[0].length;col++){//"arr1[0].length" to know column number.
                sum[row][col] = arr1[row][col]+arr2[row][col]; 
            }
        }
        for(int i = 0; i<sum.length; i++){
            for(int j =0; j<sum[0].length; j++){
                System.out.format("%d\t" ,sum[i][j]);
            }
            System.out.println(" ");
        }
     }
}

*/