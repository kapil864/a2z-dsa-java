import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q13_countSubarrysWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        System.out.println(countSubArryWithKSum(arr, k));
        sc.close();
    }


    // similar to maxLen subarry with sum K
    private static int countSubArryWithKSum(int[] arr, int k) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int tempSum = 0;
        int ans = 0;
        sumMap.put(tempSum,1);
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            
            // calculate total-k
            int prefixSum = tempSum-k;

            // Add the number of subarrays to be removed:
            ans += sumMap.getOrDefault(prefixSum, 0);

            // store total sum 
            sumMap.put(tempSum, sumMap.getOrDefault(tempSum, 0) + 1);
        }
        return ans;
    }
}
