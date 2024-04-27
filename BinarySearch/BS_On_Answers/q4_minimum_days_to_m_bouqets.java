import java.util.Arrays;
import java.util.Scanner;

public class q4_minimum_days_to_m_bouqets {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int bouquets = sc.nextInt();
        int flowers = sc.nextInt();
        int days = getDaysToMakeBouquets(arr, bouquets, flowers);
        System.out.println("Days taken: " + days);
        sc.close();
    }

    private static int getDaysToMakeBouquets(int[] bloomDay, int m, int k) {
        if ( bloomDay.length < m * k) {
            return -1;
        }

        int st = Integer.MAX_VALUE;
        int ed = Integer.MIN_VALUE;

        for (int i : bloomDay) {
            st = Integer.min(st, i);
            ed = Integer.max(ed, i);
        }

        int ans = -1;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (isValid(mid, bloomDay, m, k)) {
                ans = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isValid(int mid, int[] bloomDay, int m, int k) {
        int bouquets = 0;
        int i = 0;
        int len = bloomDay.length;
        while (i < len) {
            int flowers = 0;
            while (i < len && flowers < k && bloomDay[i] <= mid) {
                flowers++;
                i++;
            }
            if (flowers == k) {
                bouquets++;
            } else {
                i++;
            }
        }
        return bouquets >= m;
    }

}