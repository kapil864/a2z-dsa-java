package Arrays.Medium;

import java.util.Scanner;

public class q5_bestTimeToBuySellStoks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        // element that occurs more than n/2 times
        System.out.println(maxProfit(arr));
        sc.close();
    }

    // optimal approach
    // max average will be when stock is bought on a lower price than the current
    // price
    // TC = O(n) and SC = O(1)
    private static int maxProfit(int[] arr) {
        int mxPro = 0;

        // to tack the min price
        // update it when a new min is found
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Integer.min(arr[i], min);
            mxPro = Integer.max(arr[i] - min, mxPro);
        }

        if (mxPro > 0) {
            return mxPro;
        }
        return 0;
    }
}
