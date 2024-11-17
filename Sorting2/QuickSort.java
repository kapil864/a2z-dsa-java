package Sorting2;

import java.util.Scanner;

public class QuickSort {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int st, int ed) {
        int pivot = st;
        int l = st;
        int h = ed;

        while (l < h) {
            while (l < ed && arr[l] <= arr[pivot]) {
                l++;
            }

            while (h > st && arr[h] > arr[pivot]) {
                h--;
            }
            if (l < h) {
                swap(arr, l, h);
            }

        }
        swap(arr, pivot, h);
        return h;
    }

    public static void sort(int[] arr, int st, int ed) {
        if (st >= ed) {
            return;
        }

        int pivot = partition(arr, st, ed);
        sort(arr, st, pivot - 1);
        sort(arr, pivot + 1, ed);
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
