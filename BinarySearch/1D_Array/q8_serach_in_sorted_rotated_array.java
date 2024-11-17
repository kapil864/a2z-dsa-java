import java.util.Scanner;

public class q8_serach_in_sorted_rotated_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int pos = searchOptimal(arr, key);
        System.out.println(
                "For " + key + " :: position is : " + pos);
        sc.close();
    }

    // Optimal Approach
    // TC = LogN
    private static int searchOptimal(int[] arr, int key) {
        int st = 0;
        int ed = arr.length - 1;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[st] <= arr[mid]) {
                if (key >= arr[st] && key <= arr[mid]) {
                    ed = mid - 1;
                } else {
                    st = mid + 1;
                }
            } else {
                if(key <= arr[ed] && key >= arr[mid]){
                    st = mid +1;
                }
                else{
                    ed = mid -1;
                }
            }
        }
        return -1;
    }
}
