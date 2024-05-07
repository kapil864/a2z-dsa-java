import java.util.Scanner;

public class q7_kth_missing_positive_number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int integer = sc.nextInt();
        int kthNumber = getKthPositiveNumber(arr, integer);
        System.out.println("Kth positive number: " + kthNumber);
        sc.close();
    }

    private static int getKthPositiveNumberBrute(int[] arr, int integer) {
        for (int i : arr) {
            if (i <= integer) {
                integer++;
            } else {
                break;
            }
        }
        return integer;
    }

    private static int getKthPositiveNumber(int[] arr, int k) {
        int st = 0;
        int ed = arr.length -1;
        while (st <= ed) {
            int mid = st - ( st-ed)/2;
            int no_of_missing = arr[mid] - mid -1;
            if (no_of_missing < k){
                st = mid +1;
            }
            else {
                ed = mid -1;
            }
        }
        // return k+ed+1;
        return st+k;

    }
}
