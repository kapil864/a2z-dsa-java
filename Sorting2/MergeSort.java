package Sorting2;

import java.util.Scanner;

public class MergeSort {

    public static void merge(int[] arr, int st, int mid, int ed) {
        
        int tempArrSize = ed - st + 1;

        int[] tempArr = new int[tempArrSize];


        int lpt = st;
        int rpt = mid+1;
        int tempArrIdx =0;


        while (lpt <= mid && rpt <= ed) {
            if (arr[lpt] < arr[rpt]) {
                tempArr[tempArrIdx] = arr[lpt];
                lpt++;
            } else {
                tempArr[tempArrIdx] = arr[rpt];
                rpt++;
            }
            tempArrIdx++;
        }

        while (lpt <= mid) {
            tempArr[tempArrIdx] = arr[lpt];
            lpt++;
            tempArrIdx++;
        }

        while (rpt <= ed){
            tempArr[tempArrIdx] = arr[rpt];
            rpt++;
            tempArrIdx++;
        }

        for( int i =0; i<tempArr.length; i++){
            arr[st+i] = tempArr[i];
        }
    }

    public static void sort(int arr[], int st, int ed) {

        if (st >= ed) {
            return;
        }

        int mid =  ((ed +st) / 2);
        sort(arr, st, mid);
        sort(arr, mid + 1, ed);
        merge(arr, st, mid, ed);
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
        sort(arr, 0, arr.length - 1);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }

}
