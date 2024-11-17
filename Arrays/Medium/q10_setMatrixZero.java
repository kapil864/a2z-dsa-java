public class q10_setMatrixZero {

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        setZerosOptimal(matrix);
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
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    // better approach
    // create two arrays (row array, col array)
    // each array will tell weather row or coloum has to made zero
    private static void setZerosBetter(int[][] matrix) {
        int[] colArry = new int[matrix[0].length];
        int[] rowArry = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    colArry[j] = -1;
                    rowArry[i] = -1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowArry[i] == -1 || colArry[j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // optimal Approach
    // instead of creating two arrays. use existing matrix two mark positions of
    // zeros.
    // top row for columns and leftmost col for rows.
    // since there will be issues since first element matrix[0][0] will be common so
    // store it in different variable
    // upadate values with zeros from bottom right
    // update leftmost row and finally top row
    private static void setZerosOptimal(int[][] matrix) {
        boolean col0 = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0) {
                    col0 = true;
                } else if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j > 0; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if(col0){
                matrix[i][0] = 0;
            }

        }

    }
}
