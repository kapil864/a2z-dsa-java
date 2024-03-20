import java.util.Scanner;

public class q7_no_of_occurrence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int count = noOfOccurrence(arr, key);
        System.out.println(
                "For " + key + " :: count is : " + count);
        sc.close();
    }

    private static int noOfOccurrence(int[] arr, int key) {
        return getLastOccurrence(arr, key) - getFirstOccurrence(arr, key) + 1;
    }

    private static int getLastOccurrence(int[] arr, int key) {
        int st = 0;
        int ed = arr.length - 1;
        int ans = -1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] == key) {
                ans = mid;
                st = mid + 1;
            } else if (arr[mid] > key) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }

        }
        return ans;
    }

    private static int getFirstOccurrence(int[] arr, int key) {
        int st = 0;
        int ed = arr.length - 1;
        int ans = -1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] == key) {
                ans = mid;
                ed = mid - 1;
            } else if (arr[mid] > key) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }

        }
        return ans;
    }
}
