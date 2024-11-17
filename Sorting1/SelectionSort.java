package Sorting1;

import java.util.Scanner;

public class SelectionSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr) {
        for( int i = 0; i<arr.length-1; i++){
            int maxIdx = 0;
            for( int j =1; j<arr.length-i; j++){
                if(arr[j]>arr[maxIdx]){
                  maxIdx = j;  
                }
            }
            swap(arr, arr.length-i-1, maxIdx);
        }
    }

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
        sort(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }
}
