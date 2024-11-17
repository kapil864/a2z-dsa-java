package Sorting2;

import java.util.Scanner;

public class BubbleSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort( int[] arr, int st, int ed){

        if(st==ed){
            return;
        }
        
        for( int i = st; i<ed; i++){
            if(arr[i]>arr[i+1]){
                swap(arr, i, i+1);
            }
        }
        sort(arr, st, ed-1);
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
        sort(arr, 0, arr.length-1);
        System.out.println();
        for (int i : arr) {
            System.out.print(i+" ");
        }
        sc.close();
    }
    
}
