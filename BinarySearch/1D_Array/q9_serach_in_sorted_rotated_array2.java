import java.util.Scanner;

public class q9_serach_in_sorted_rotated_array2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int pos = searchOptimal(arr, key);
        System.out.println(
                "For " + key + " :: position is : " + pos);
        sc.close();
    }

    // TC = O(LogN) for best and average case
    private static int searchOptimal(int[] arr, int key) {
        int st = 0;
        int ed = arr.length - 1;
        while (st <= ed) {
            int mid = (st + ed) / 2;

            // // TC = O(N) for worst case
            // // when using two while loops for discarding equal values
            // while(arr[st] == arr[mid] && st < mid){
            // st++;
            // }
            // while (arr[ed]== arr[mid] && ed > mid) {
            // ed--;
            // }
            if (arr[mid] == key) {
                return mid;
            }

            // using this if condition two values will be discarded at once
            // Worst case time complexity with this case is O(N/2)
            else if (arr[mid] == arr[st] && arr[mid] == arr[ed]) {
                st++;
                ed--;
            } else if (arr[st] <= arr[mid]) {
                if (key >= arr[st] && key <= arr[mid]) {
                    ed = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {
                if (key <= arr[ed] && key >= arr[mid]) {
                    st = mid + 1;
                } else {
                    ed = mid - 1;
                }
            }
        }
        return -1;
    }

}
