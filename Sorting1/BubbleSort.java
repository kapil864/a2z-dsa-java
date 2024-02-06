package Sorting1;

import java.util.Scanner;


public class BubbleSort {

    public static int[] sort(int[] arr){
        for(int i =0; i<arr.length; i++){
            for( int j = 0; j<arr.length-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp =arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]=temp;
                }
            } 
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        for (int i : arr) {
            System.out.print(arr[i] + " ");
        }
        arr = sort(arr);
        for (int i : arr) {
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
