import java.util.Arrays;
import java.util.Scanner;

public class q6_cpacity_to_ship_packages {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int days = sc.nextInt();
        int capacity = shipWithinDays(arr, days);
        System.out.println("Min Ship Capacity: " + capacity);
        sc.close();
    }

    private static int shipWithinDays(int[] arr, int days) {
        int st = Arrays.stream(arr).max().getAsInt();
        int ed = Arrays.stream(arr).sum();
        int ans = 0;
        while ( st <= ed){
            int mid = st + (ed - st )/2;
            if ( isValid(mid, arr, days)){
                ans= mid;
                ed = mid-1;
            }
            else{
                st = mid +1;
            }
        }
        return ans;
    }

    private static boolean isValid(int mid, int[] arr, int days) {
        int daysTaken = 0;
        int weights  =0;
        int pos = 0;
        while ( pos < arr.length){
            weights += arr[pos];
            if (weights > mid){
                weights = arr[pos];
                daysTaken ++;
            }
            else if (weights == mid){
                weights= 0;
                daysTaken++;
            }
            pos++;
        }
        if (weights > 0){
            daysTaken++;
        }
        return daysTaken <= days;
    }
}