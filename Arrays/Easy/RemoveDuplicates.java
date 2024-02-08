package Arrays.Easy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicates {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void bruteRemoveDuplicates(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                for (int j = i; j < arr.length - 1; j++) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void bruteRemoveDuplicates2(int[] arr) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        Integer[] tempList = set.toArray(new Integer[set.size()]);
        for (int i = 0; i < set.size(); i++) {
            arr[i] = tempList[i];
        }
    }

    // using two pointer method, one to keep unique elemnts
    // to check for duplicate element
    private static void optimalRemoveDuplicates(int[] arr) {
        int i =0;
        int j = 1;
        while(j<arr.length){
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
            j++;
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
        optimalRemoveDuplicates(arr);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }

}
