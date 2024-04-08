package BinarySearch.BS_On_Answers;

import java.util.Scanner;

public class q3_koko_eating_bananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pileSize = sc.nextInt();
        int[] arr = new int[pileSize];
        for (int i = 0; i < pileSize; i++) {
            arr[i] = sc.nextInt();
        }
        int hour = sc.nextInt();
        int speed = minEatingSpeed(arr, hour);
        System.out.println("Speed for eating bananas: " + speed);
        sc.close();
    }

    private static boolean isValidSpeed(int[] pile, int speed, int hours) {
        long hoursTaken = 0;
        for (int i = 0; i < pile.length; i++) {
            if (pile[i] <= speed) {
                hoursTaken++;
            } else {
                hoursTaken += (pile[i] / speed);
                int remain = (pile[i] % speed);
                if (remain > 0) {
                    hoursTaken++;
                }
            }
        }

        if (hoursTaken > hours)
            return false;
        return true;
    }

    public static int minEatingSpeed(int[] pile, int hours) {
        int n = pile.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, pile[i]);
        }
        int ans = 0;
        int st = 1, ed = max;
        while (st <= ed) {
            int mid = st + (ed - st) / 2;
            if (isValidSpeed(pile, mid, hours)) {
                ans = mid;
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return st;
    }

}
