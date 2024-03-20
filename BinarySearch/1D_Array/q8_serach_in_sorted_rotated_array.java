import java.util.Scanner;

public class q8_serach_in_sorted_rotated_array {
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

    // Optimal Approach
    // TC = LogN
    private static int searchOptimal(int[] arr, int key) {
        int st = 0;
        int ed = arr.length - 1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[st] <= arr[mid]) {
                if (key >= arr[st] && key <= arr[mid]) {
                    ed = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {
                if(key <= arr[ed] && key >= arr[mid]){
                    st = mid +1;
                }
                else{
                    ed = mid -1;
                }
            }
        }
        return -1;
    }

    //////////////////////////////////////////////////////////////////////
    // Approach
    // Get the rotation point
    // Perform binary search in two parts
    // TC = O(2LogN)
    private static int search(int[] arr, int key) {
        int rotationPoint = getRotationPoint(arr);
        if (rotationPoint == -1) {
            return binarySearch(arr, key, 0, arr.length - 1);
        }
        int ans = binarySearch(arr, key, 0, rotationPoint - 1);
        if (ans != -1)
            return ans;
        return binarySearch(arr, key, rotationPoint, arr.length - 1);
    }

    private static int getRotationPoint(int[] arr) {
        int st = 0;
        int ed = arr.length - 1;
        if (arr[st] < arr[ed]) {
            return -1;
        }
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[ed]) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int key, int st, int ed) {
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return -1;
    }
}
