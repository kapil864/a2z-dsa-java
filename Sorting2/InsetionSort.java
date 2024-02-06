package Sorting2;

import java.util.Scanner;

public class InsetionSort {

    public static void sort(int[] arr){

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
