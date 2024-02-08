package Arrays.Easy;

import java.util.Scanner;

public class LeftRotateArray {
    public static void Reverse(int[] arr, int start, int end) {
        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int rotateTimes = sc.nextInt();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        
        leftRotateArrayOptimal(arr, rotateTimes);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    // Copy first k-1 elements to a tempArrry
    // Then move elememts from K to n by k places
    // Copy elements form temp arry to original arrray
    private static void leftRotateArrayBrute(int[] arr, int k) {
        k = k % arr.length;
        int[] tempArry = new int[k];
        for (int i = 0; i < k; i++) {
            tempArry[i] = arr[i];
        }
        for (int i = 0; i < arr.length - k; i++) {
            arr[i] = arr[i + k];
        }
        for (int i = arr.length - k; i < arr.length; i++) {
            arr[i] = tempArry[i - arr.length + k];
        }

    }

    private static void leftRotateArrayOptimal(int[] arr, int k) {

        k = k % arr.length;
        Reverse(arr, 0, k-1);
        Reverse(arr, k, arr.length - 1);
        Reverse(arr, 0, arr.length-1);

    }

    private static void rightRotateArrayOptimal(int[] arr, int k) {

        k = k % arr.length;
        Reverse(arr, 0, arr.length-k-1);
        Reverse(arr, arr.length-k, arr.length - 1);
        Reverse(arr, 0, arr.length - 1);

    }

}
