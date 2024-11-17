import java.util.Scanner;

public class q5_floor_ciel_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int[] pos = getFloorCeil(arr, key);
        System.out.println("For " + key + " :: \nPosition of \nFloor is : " + pos[0] + "\nCeil is : " + pos[1]);
        sc.close();
    }

    private static int[] getFloorCeil(int[] arr, int key) {
        int st = 0;
        int ed = arr.length - 1;
        int mid = -1;
        while (st <= ed) {
            mid = (st + ed) / 2;
            if (arr[mid] == key) {
                return new int[] { mid, mid };
            } else if (arr[mid] < key) {
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return new int[] { mid, mid + 1 };
    }

}
