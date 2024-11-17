import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class q8_leaderElements {
    public static void main(String[] args) {
        {
            Scanner sc = new Scanner(System.in);
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            // element that occurs more than n/2 times
            List<Integer> sol = leaders(arr, size);
            for (int i : sol) {
                System.out.print(i + " ");
            }
            sc.close();
        }
    }

    private static List<Integer> leaders(int[] arr, int size) {
       List<Integer> sol = new ArrayList<>();
       int mx = size-1;
       sol.add(arr[mx]);
       for(int i = size-2; i>=0; i--){
        if(arr[mx]<arr[i]){
            mx = i;
            sol.add(arr[mx]);
        }
       }
       return sol;
    }
}
