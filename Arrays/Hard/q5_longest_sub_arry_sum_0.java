import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q5_longest_sub_arry_sum_0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int sol = subArrayOptimal(arr);
        System.out.println("Longest sub-array length is "+sol);
        sc.close();
    }

    // TC = O(N^2)
    // Find all possible subarrays and calucluate their sum
    private static int subArrayBrute(int[] arr) {
        int ans = 0;
        for(int i  =0; i<arr.length; i++){
            long tempSum=0;
            for(int j = i; j<arr.length; j++){
                tempSum += arr[j];
                if(tempSum==0){
                    ans = Integer.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }

    // using hashmap
    // if sum till i is S
    // and if there exists a sum S for a subarray previously
    // then the sum of middle elemets must be equal to 0
    private static int subArrayOptimal(int[] arr){
        int idx = 0;
        int ans = 0;
        int prefixSum = 0;
        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        while(idx<arr.length){
            
            prefixSum += arr[idx];

            if(prefixSum==0){
                ans = idx+1;
            }

            // checking if there exists a prefixsum
            if(prefixSumMap.containsKey(prefixSum)){
                ans = Integer.max(ans, idx-prefixSumMap.get(prefixSum));
            }

            if(!prefixSumMap.containsKey(prefixSum)){
                prefixSumMap.put(prefixSum,idx);
            }
            
            idx++;
            
        }
        return ans;
    }

}
