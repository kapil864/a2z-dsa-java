import java.util.Arrays;
import java.util.Scanner;

public class q8_merge_soreted_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int[] arr = new int[size1];
        for (int i = 0; i < size1; i++) {
            arr[i] = sc.nextInt();
        }
        int size2 = sc.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        mergeSortedOptimal2(arr, arr2);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : arr2) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    // Since we know that right of arr1 must contain values smaller then values at
    // left of arr2
    // so traverse each of element in that order and swap elements if they are not
    // in valid order
    // finally sort the individual arrays
    // TC = O(min(m,n)) + O(MlogM + NlogN)
    private static void mergeSortedOptimal1(int[] arr, int[] arr2) {
        int left = arr.length - 1;
        int right = 0;
        while (left >= 0 && right < arr2.length) {
            if (arr[left] > arr2[right]) {
                swap(arr, arr2, left, right);
                left--;
                right++;
            } else {
                break;
            }
        }
        Arrays.sort(arr);
        Arrays.sort(arr2);
    }

    public static void swap(int[] arr1, int[] arr2, int i, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    // Based on gap method (used in shell sort)
    // TC = O((M+n)Log(m+n))
    private static void mergeSortedOptimal2(int[] arr, int[] arr2) {
        int n = arr.length;
        int m = arr2.length;
        int len = n + m;
        int gap = (len / 2) + (len % 2);
        while(gap >0){
            int left =0;
            int right = left+gap;
            while(right < len){

                // if left is in arr1 and right is in arr2
                if (left < n && right >= n){
                    swapIfGreater(arr, arr2, left, right-n);
                }
                // left is in arr2 and right is arr2
                else if (left >=n){
                    swapIfGreater(arr2, arr2, left-n, right-n);
                }
                // left is in arr1 and right is in arr1
                else{
                    swapIfGreater(arr, arr, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1){
                break;
            }
            gap = (gap/2) + (gap%2);
            
        }

    }

    private static void swapIfGreater(int[] arr, int[] arr2, int left, int right) {
       if(arr[left]>arr2[right]){
        swap(arr, arr2, left, right);
       }
    }


}
