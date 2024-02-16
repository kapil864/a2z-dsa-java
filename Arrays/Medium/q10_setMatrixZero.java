public class q10_setMatrixZero {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        setZerosBrute(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    // traverse matrix and mark rows and columns with -1 of element which is zero
    // replace all -1 with the 0 in another iteration
    private static void setZerosBrute(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int col = 0; col < matrix[i].length; col++) {
                        if (matrix[i][col] != 0) {
                            matrix[i][col] = -1;
                        }
                    }

                    for (int row = 0; row < matrix.length; row++) {
                        if (matrix[row][j] != 0) {
                            matrix[row][j] = -1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==-1){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
