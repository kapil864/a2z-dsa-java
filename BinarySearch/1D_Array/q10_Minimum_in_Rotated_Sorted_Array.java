import java.util.Scanner;

public class q10_Minimum_in_Rotated_Sorted_Array {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int pos = getMinimum(arr);
        System.out.println("Minimum in array is : " + arr[pos]);
        sc.close();
    }

    // TC = O(Log N)
    private static int getMinimum(int[] arr) {
        int N = arr.length;

        // Edge cases
        if (arr.length == 1) {
            return 0;
        } else if (arr.length == 2) {
            return arr[0] > arr[1] ? 1 : 0;
        }

        int st = 0;
        int ed = N - 1;
        if (arr[st] < arr[ed]) {
            return st;
        }
        while (st <= ed) {
            int mid = (st + ed) / 2;

            // to take care of edge case of lowest element is at right most side of array
            if( mid == N-1 && arr[mid] < arr[mid - 1]){
                return mid;
            }
            else if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[ed]) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return -1;
    }


    // Approach 2
    private static int findMin(int[] arr){
        int low = 0, high = arr.length - 1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;

            // search space is already sorted
            // then arr[low] will always be
            // the minimum in that search space:
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }

            // if left part is sorted:
            if (arr[low] <= arr[mid]) {
                // keep the minimum:
                ans = Math.min(ans, arr[low]);

                // Eliminate left half:
                low = mid + 1;

            } else { // if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr[mid]);

                // Eliminate right half:
                high = mid - 1;
            }
        }
        return ans;
    }
    
}