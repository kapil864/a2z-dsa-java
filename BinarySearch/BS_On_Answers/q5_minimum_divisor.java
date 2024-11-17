import java.util.Arrays;
import java.util.Scanner;

public class q5_minimum_divisor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int threshold = sc.nextInt();
        int days = smallestDivisor(arr, threshold);
        System.out.println("Days taken: " + days);
        sc.close();
    }

    private static int smallestDivisor(int[] arr, int threshold) {
        int st = 1;
        int ed = Arrays.stream(arr).max().getAsInt();
        int ans = -1;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (isValid(mid, arr, threshold)) {
                ans = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isValid(int mid, int[] arr, int threshold) {
        int sum = 0;
        for (int i : arr) {
            if (i > mid) {
                if (i % mid == 0)
                    sum += i / mid;
                else
                    sum += (i / mid) + 1;
            } else
                sum += 1;
        }
        if (sum <= threshold) {
            return true;
        }
        return false;
    }

}