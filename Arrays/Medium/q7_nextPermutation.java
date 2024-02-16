import java.util.Scanner;

public class q7_nextPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        // element that occurs more than n/2 times
        int[] sol = nextPermutation(arr, size);
        for (int i : sol) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // using optimal approach
    // since the next permutation will be just next greater number
    // so find a element (idx) which is lower from right element
    // then swap this with element which is just greater than element found above
    // reverse the arry from idx+1 to ed
    private static int[] nextPermutation(int[] arr, int size) {
        int idx = -1;
        for (int i = size - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            reverse(arr, 0, size - 1);
            return arr;
        }
        for (int i = size - 1; i > idx; i--) {
            if (arr[i] > arr[idx]) {
                swap(arr, idx, i);
                break;
            }
        }
        reverse(arr, idx + 1, size - 1);
        return arr;
    }

    private static void reverse(int[] a, int st, int ed) {
        {
            while (st < ed) {
                swap(a, st, ed);
                st++;
                ed--;
            }
        }
    }
}
