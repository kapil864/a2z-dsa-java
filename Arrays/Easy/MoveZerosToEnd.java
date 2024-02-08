package Arrays.Easy;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Scanner;

public class MoveZerosToEnd {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        bruteMoveZeros(arr);
        moveZerosOptimal(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    // can use a two pointer apporach 
    // use one pointer to track non zero elements (pt1)
    // use other pointer (pt2) to swap zero with non zero element
    private static void moveZerosOptimal(int[] arr) {
        int pt1 = 0;
        int pt2 = 0;

        // find location of first zero
        while(pt1 <arr.length && arr[pt1] != 0){
            pt1++;
        }

        // return if no zeros are found
        if(pt1 == arr.length) return;

        // initiallize second pointer
        pt2 = pt1+1;
        while(pt2 < arr.length){

            // swap with non zero element
            if(arr[pt2] != 0){
                swap(arr, pt1, pt2);
                pt1++;
            }

            pt2++;
            
        }
    }

    // store all non zero elements to a temporary array
    // copy elememts from tempArry to original array
    private static void bruteMoveZeros(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        int[] tempArr = new int[arr.length - count];
        int idx1 = 0, indx2 = 0;
        while (indx2 < arr.length) {
            if (arr[indx2] != 0) {
                tempArr[idx1] = arr[indx2];
                idx1++;
            }
            indx2++;
        }
        idx1 = 0;
        indx2 = 0;
        while (indx2 < tempArr.length){
            arr[idx1] = tempArr[indx2];
            indx2++;
            idx1++;
        }

        while(idx1 <arr.length){
            arr[idx1]=0;
            idx1++;
        }

    }

    
}
