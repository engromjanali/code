package basic_java;
public class array_pattern {
    public static void main(String[] args) {

        int [][] a;
        a = new int[4][];
        a[0] = new int [1];
        a[1] = new int [2];
        a[2] = new int [3];
        a[3] = new int [4];
        int k=1;
        
         
        for ( int row = 0; row <4; row ++){
            for ( int col = 0; col <row +1; col ++){

                a [row][col] = k;
                k++;

                
            }
        }

        for ( int row = 0; row <4; row ++){
            for ( int col = 0; col <row+1; col ++){
                System.out.print(" "+ a[row][col]);

            }
            System.out.println();
        }
    }
}
