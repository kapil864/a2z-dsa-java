import java.util.Scanner;

public class q2_lower_bound {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int pos = lowerBound(arr, key);
        System.out.println("Lower bound of " + key + " is : " + pos);
        sc.close();
    }

    private static int lowerBound(int[] arr, int key) {
        int st = 0;
        int ed = arr.length - 1;
        int mid = -1;
        while (st <= ed) {
            mid = (st + ed) / 2;

            // added condition for lower bound
            if (arr[mid] >= key) {
                ed = mid-1;
            } else if (arr[mid] < key) {
                st = mid + 1;
            }
        }
        return mid;
    }
}
