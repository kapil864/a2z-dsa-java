import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q9_mssing_and_repeating_no {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println();
        int[] ans = findMissingRepeatingBrute(arr);
        System.out.println("Repeating no " + ans[0]+ " Missing no: "+ ans[1]);
        sc.close();
    }

    private static int[] findMissingRepeatingBrute(int[] arr) {
        Set<Integer> unique = new HashSet<>();
        int[] ans = new int[2];
        for(int i =0; i < arr.length; i++){
            for(int j = i+1; j<arr.length; j++){
                    
                if(arr[i] == arr[j]){
                    ans[0] = arr[i];
              
                }
            }
            unique.add(arr[i]);
        }

        for(int i =0; i<arr.length; i++){
            if (!unique.contains(i+1)){
                ans[1] = i;
            }
        }
        return ans;
    }
}
