package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q1_pascalsTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // get entire pascal triangle using brute force
        List<List<Integer>> pacalTriangle = pascalsTriangleVarient(N);
        for (List<Integer> row : pacalTriangle) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
        int row = sc.nextInt();
        int col = sc.nextInt();
        int printRow = sc.nextInt();

        // get specific element
        System.out.println("Element at row: " + row + " col: " + col);
        System.out.println(getElement(row, col));
        System.out.println();
        
        // print a row
        System.out.println("Row " + printRow);
        List<Integer> nthRow = getRowOptimal(printRow);
        for (int integer : nthRow) {
            System.out.print(integer + " ");
        }

        sc.close();
    }

    // generate pascal triangle
    private static List<List<Integer>> pascalsTriangleBrute(int n) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        sol.add(row1);
        for (int i = 1; i < n; i++) {
            List<Integer> nxtRow = new ArrayList<>(i + 1);
            int itr = 1;
            nxtRow.add(0, 1);
            while (itr <= i - 1) {
                nxtRow.add(itr, (sol.get(i - 1).get(itr - 1) + sol.get(i - 1).get(itr)));
                itr++;
            }
            nxtRow.add(i, 1);
            sol.add(nxtRow);
        }
        return sol;
    }

    // get element at nth row and cth column of pascal triangle optimal approach
    // We can use combination formula nCr
    // to get element at nth row and cth column (n-1)C(c-1)
    private static int getElement(int row, int col) {
        return combinationFormula(row - 1, col - 1);
    }

    // get a specific row
    // this approach uses the getElement method to get each element for a row
    // TC = O(N*N) SC = O(1)
    private static List<Integer> getRowBetter(int N) {
        List<Integer> row = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            row.add(getElement(N, i));
        }
        return row;
    }

    // get specific row optimal
    // using observation
    // TC = O(N)
    // refer notes
    private static List<Integer> getRowOptimal(int N) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        int temp = 1;
        for (int i = 1; i < N; i++) {
            temp = temp * (N - i);
            temp = temp / i;
            row.add(temp);
        }
        return row;
    }

    // print pascals triangle
    // TC = O(N*N)
    private static List<List<Integer>> pascalsTriangleVarient(int n) {
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<Integer> tempRow = getRowOptimal(i);
            sol.add(tempRow);
        }
        return sol;
    }

    private static int combinationFormula(int n, int r) {
        int ans = 1;
        for (int i = 1; i <= r; i++) {
            ans = ans * (n - i + 1);
            ans = ans / (i);
        }
        return ans;
    }

}
