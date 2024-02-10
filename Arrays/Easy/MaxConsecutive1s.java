package Arrays.Easy;

import java.util.Scanner;

public class MaxConsecutive1s {
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
        System.out.println();
        System.out.println("Max consecutive 1s are  "+ maxConsecutive1s(arr));
        // for (int i : arr) {
        //     System.out.print(i + " ");
        // }
        sc.close();
    }

    private static int maxConsecutive1s(int[] arr) {
        int maxCount =0;
        int idx=0;
        while(idx < arr.length){
            int tempCount =0;
            while (idx < arr.length && arr[idx] == 1) {
                tempCount++;
                idx++;
            }
            if( tempCount > maxCount)
                maxCount = tempCount;
            idx++;
        }

        return maxCount;

    }
}
