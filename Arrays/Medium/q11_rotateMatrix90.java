public class q11_rotateMatrix90 {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotateMatrixOptimal(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // transpose the matrix
    // reverse the rows in matrix
    // TC = O(2 N^2)
    private static void rotateMatrixOptimal(int[][] matrix) {
        for( int i =0 ; i< matrix.length; i++){
            for( int j = i; j<matrix[i].length; j++){
                swap(matrix, i, j, j, i);
            }
        }

        for(int i =0; i<matrix.length;i++){
            reverse(matrix[i], 0, matrix.length-1);
        }
    }

    private static void reverse(int[] a, int st, int ed) {
        {
            while (st < ed) {
                swap(a, st, ed);
                st++;
                ed--;
            }
        }
    }

    public static void swap(int[][] arr, int a, int b, int x, int y) {
        int temp = arr[a][b];
        arr[a][b] = arr[x][y];
        arr[x][y] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
