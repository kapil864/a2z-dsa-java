import java.util.Scanner;

public class q12_single_element_in_a_sorted_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int pos = getSingleElement(arr);
        System.out.println("Single element is: " + arr[pos]);
        sc.close();
    }

    // 1-> determine which half to reject/ select
    // 2-> condition for single element
    // 1-> after taking a close look at array one can say that
    // from starting repeating elements are at (odd, even) position
    // after a single element has occurred then they are at (even, odd) positions
    // 2-> from above one can infer which half to select and condition for single
    // element
    private static int getSingleElement(int[] arr) {
        int len = arr.length;

        // if size of array is 1
        if (len == 1)
            return 0;

        // if first element is single element
        else if (arr[0] != arr[1]) {
            return 0;
        }

        // if last element is a single element
        else if (arr[len - 1] != arr[len - 2]) {
            return len - 1;
        }

        int st = 1, ed = len - 2;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid - 1] != arr[mid] && arr[mid] != arr[mid + 1]) {
                return mid;
            } else if ((mid % 2 == 1 && arr[mid] == arr[mid - 1]) || (mid % 2 == 0 && arr[mid] == arr[mid + 1])) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return -1;
    }
}
