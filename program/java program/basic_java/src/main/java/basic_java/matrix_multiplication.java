public class matrix_multiplication{
    public static void main(String[]args){
        int [][]arrayA={{1,3,5},{4,3,6},{6,8,6}};
        int [][]arrayB={{1,3,5},{4,3,6},{6,8,6}};

        int rowsizeA=arrayA.length;
        int rowsizeB=arrayB.length;//no needed.
        int columnsizeA = arrayA[0].length;
        int columnsizeB = arrayB[0].length;

        int [][] result = new int[rowsizeA][columnsizeB];//resultROW=A_ROW, resultcolumn = B_COLUMN;

        for(int i =0; i<rowsizeA; i++){
            for(int j = 0 ; j<columnsizeB;j++){
                for(int k =0; k<columnsizeA; k++){
                    result[i][j] += arrayA[i][k]*arrayB[k][j];

                }
            }
        }
        for(int i= 0; i<result.length;i++){
            for(int j = 0; j<result[0].length;j++){
                System.out.format("%d\t",result[i][j]);
            }
             System.out.println(" ");
        }

    }
}
