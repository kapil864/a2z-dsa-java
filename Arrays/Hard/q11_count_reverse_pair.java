import java.util.Scanner;

public class q11_count_reverse_pair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int inversions = countReversePairsOptimal(arr);
        System.out.println("Total number of reverse pairs are : " + inversions);
        sc.close();
    }

    // Brute force method
    // TC = O(N^2)
    private static int countReversePairsBrute(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > 2 * arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimal method
    //
    private static int countReversePairsOptimal(int[] arr) {
        return mergeSort(arr, 0, arr.length-1);
    }

    // the function wich will count how many reverses are there that match the
    // condition
    // if arr[i] has 2 pairs then no for element greater than arr[i] will also have
    // pairs that arr[i] has
    private static int countReverse(int[] arr, int st, int ed, int mid) {
        int count = 0;
        int left = st;
        int right = mid+1;
        while(left<= mid){
            while(right <= ed && arr[left] > (long)2*arr[right]){
                right++;
            }
            count += right-mid-1;
            left++;
        }
        return count;
    }

    private static void merge(int[] arr, int st, int ed, int mid) {
        int size = ed - st + 1;
        int[] tempArr = new int[size];

        int left = st;
        int right = mid + 1;
        int tempArrIdx = 0;
        while (left <= mid && right <= ed) {

            if (arr[left] <= arr[right]) {
                tempArr[tempArrIdx] = arr[left];
                left++;
            } else {
                tempArr[tempArrIdx] = arr[right];
                right++;
            }
            tempArrIdx++;
        }

        while (left <= mid) {
            tempArr[tempArrIdx] = arr[left];
            left++;
            tempArrIdx++;
        }

        while (right <= ed) {
            tempArr[tempArrIdx] = arr[right];
            right++;
            tempArrIdx++;
        }

        for (int i = 0; i < tempArr.length; i++) {
            arr[st + i] = tempArr[i];
        }

    }

    private static int mergeSort(int[] arr, int st, int ed) {
        int count = 0;
        if (st >= ed) {
            return count;
        }
        int mid = (st + ed) / 2;
        count += mergeSort(arr, st, mid);
        count += mergeSort(arr, mid + 1, ed);
        count += countReverse(arr, st, ed, mid);
        merge(arr, st, ed, mid);
        return count;
    }
}
