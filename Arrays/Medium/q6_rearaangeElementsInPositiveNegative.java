package Arrays.Medium;

import java.util.ArrayList;
import java.util.Scanner;

public class q6_rearaangeElementsInPositiveNegative {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        // element that occurs more than n/2 times
        arr = rearrangeElements(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    // brute approach will be to store positive elements in a postive arry
    // negative elements in other
    // and take a element from each and put it at it's correct position

    // optimal approach
    // make two pointer/indices one to keep track of positve elements
    // other to track negative elements
    // traverse till there is positve element found and place it at it's corrct
    // position
    // same with neagtive element
    private static int[] rearrangeElements(int[] arr) {
        int positive = 0;
        int negative = 1;
        int itr = 0;
        int[] tempArr = new int[arr.length];
        while (itr < arr.length) {
            if (arr[itr] > 0) {
                tempArr[positive] = arr[itr];
                positive += 2;
            } else if (arr[itr] <= 0) {
                tempArr[negative] = arr[itr];
                negative += 2;
            }
            itr++;
        }
        return tempArr;
    }

    // modifed apprach if the number of positives and negatives are not equal;
    // use brute force method and create cases for positve and negative elements
    public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A, int n) {
        // Define 2 ArrayLists, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0)
                pos.add(A.get(i));
            else
                neg.add(A.get(i));
        }

        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {

            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }
}
