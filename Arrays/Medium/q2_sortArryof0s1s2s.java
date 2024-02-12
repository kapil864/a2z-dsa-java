package Arrays.Medium;

import java.util.List;
import java.util.Scanner;

public class q2_sortArryof0s1s2s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println();
        sortOptimal(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    // use simple method of sorting array
    private static void sortBrute(int[] arr) {
        int len = arr.length;

    }

    // using count of 0s 1s and 2s
    // insert the above numbers as per count in the existing array
    // TC = O(2N) as array is iterated twice
    private static void sortBetter(int[] arr) {
        int len = arr.length;
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        int i = 0;
        while (i < len) {
            if (arr[i] == 0) {
                zeros++;
            } else if (arr[i] == 1) {
                ones++;
            } else {
                twos++;
            }
            i++;
        }

        i = 0;

        while (zeros > 0) {
            arr[i] = 0;
            zeros--;
            i++;
        }
        while (ones > 0) {
            arr[i] = 1;
            ones--;
            i++;
        }
        while (twos > 0) {
            arr[i] = 2;
            twos--;
            i++;
        }
    }

    // three pointer
    // maintain three pointers one keeping check of 0s other for 1s, and another for
    // 2s.
    // problem is a variation of DNF (Dutch national flag algo). trick is to place
    // the 1 pointer to correct position
    //
    private static void sortOptimal(int[] arr) {
        int len = arr.length;
        int pt0 = 0;
        int pt1 = 0;
        int pt2 = len - 1;

        while (pt1 <= pt2) {
            if (arr[pt1] == 1) {
                pt1++;
            } else if (arr[pt1] == 0) {
                swap(arr, pt1, pt0);
                pt0++;
                pt1++;
            } else {
                swap(arr, pt1, pt2);
                pt2--;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
