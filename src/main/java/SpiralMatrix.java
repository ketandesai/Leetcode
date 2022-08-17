import java.util.ArrayList;

public class SpiralMatrix {

    static int[][] matrix = new int[][]{ {1, 2, 3},
                                         {4, 5, 6},
                                         {7, 8, 9} };

    public static void main(String args[]){
        ArrayList topRow = new ArrayList();
        ArrayList rightCol = new ArrayList();
        ArrayList bottomRow = new ArrayList();
        ArrayList leftCol = new ArrayList();
        for (int i = 0; i < matrix.length; i++){

            for (int j = 0; j < matrix[i].length; j++)
            {
                //top row
                if (i == 0)
                {
                    topRow.add(matrix[i][j]);
                    System.out.println(matrix[i][j]);
                }

                //right col
                if (i > 0 && (j == matrix[i].length -1)){
                    rightCol.add(matrix[i][j]);
                }

                //bottom row
                if (i == (matrix.length -1) && j < (matrix[i].length -1))
                {
                    bottomRow.add(0, matrix[i][j]);
                }
            }
        }
        System.out.println(topRow + ", " + rightCol + ", " + bottomRow);
    }
}
