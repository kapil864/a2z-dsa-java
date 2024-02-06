package Sorting1;

import java.util.Scanner;

public class InsertionSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int arr[]){
        int st = 0; 
        int ed = arr.length;
        while(st<ed){
            int idx = st;
            while(idx > 0 && arr[idx-1] > arr[idx]){
                swap(arr, idx, idx-1);
                idx--;
            }
            st++;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sort(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i+" ");
        }
        sc.close();
    }
}
