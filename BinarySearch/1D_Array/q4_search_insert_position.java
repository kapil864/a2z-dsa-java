import java.util.Scanner;

public class q4_search_insert_position {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int pos = getInsertPosition(arr, key);
        System.out.println("Insert position for " + key + " is : " + pos);
        sc.close();
    }

    private static int getInsertPosition(int[] arr, int key) {
        int st = 0;
        int ed = arr.length - 1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return st;
    }
}
