package Arrays.Easy;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int No = sc.nextInt();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(No+ " is found at "+ linerSearch(arr,No));
        // for (int i : arr) {
        //     System.out.print(i + " ");
        // }
        sc.close();
    }

    private static int linerSearch(int[] arr, int no) {
        for( int i = 0; i<arr.length; i++){
            if(arr[i] == no){
                return i+1;
            }
        }
        return -1;
    }
}
