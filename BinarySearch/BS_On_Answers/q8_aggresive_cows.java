import java.util.Arrays;
import java.util.Scanner;

public class q8_aggresive_cows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int integer = sc.nextInt();
        int ans = getMaxMinimumDistance(arr, integer);
        System.out.println("Maximum minimum distance " + ans);
        sc.close();
    }

    private static boolean isValidPlace(int[] stalls, int distance, int cows) {
        int cows_placed = 1;
        int lastPos = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPos >= distance) {
                cows_placed++;
                lastPos = stalls[i];
            }
            if (cows_placed >= cows) {
                return true;
            }

        }
        return false;
    }

    private static int getMaxMinimumDistance(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int st = 1;
        int ed = stalls[stalls.length-1]-stalls[0];
        int ans = -1;
        while (st <= ed) {
            int mid = st - (st - ed) / 2;
            if (isValidPlace(stalls, mid, cows)) {
                ans = mid;
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return ans;
    }
}
