import java.util.Scanner;

public class q11_no_of_times_rotated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int pos = getRotationCount(arr);
        System.out.println("No of times array is rotated : " + pos);
        sc.close();
    }

    private static int getRotationCount(int[] arr) {
        int st = 0;
        int ed = arr.length-1;
        int index = -1;
        int ans = Integer.MAX_VALUE;
        while(st <= ed){
            int mid = (st + ed)/2;

            // array is already sorted
            if(arr[st] < arr[ed]){
                if(arr[st] < ans){
                    ans = arr[st];
                    index = st;
                }
                return index;
            }

            // left part is sorted
            if(arr[st] <= arr[mid]){

                // keep minimum
                if(arr[st] < ans){
                    ans = arr[st];
                    index = st;
                }

                // eliminate the left half
                st = mid+1;
            }
            else{
                // right half is sorted
                if(arr[mid] < ans){
                    ans = arr[mid];
                    index = mid;
                }

                // eliminate right half
                ed = mid -1;
            }
        }
        return index;
    }
}
