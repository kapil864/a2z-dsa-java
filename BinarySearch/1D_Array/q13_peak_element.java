import java.util.Scanner;

public class q13_peak_element {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int pos = getPeakElement(arr);
        System.out.println("Peak element is at" + pos);
        sc.close();
    }

    // TC = LogN
    // if one condition of or is satisfied then it won't look for other conditions
    private static int getPeakElement(int[] arr) {
        int n = arr.length;
        int st = 0;
        int ed = arr.length - 1;
        int mid = -1;
        while (st <= ed) {
            mid = (st + ed) / 2;
            if ((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
                break;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return mid;

    }
}
