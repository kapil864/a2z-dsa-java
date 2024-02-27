import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q6_Subarray_with_given_XOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int sol = subArrayOptimal(arr, target);
        System.out.println("Number of sub-arrays is "+sol);
        sc.close();
    }


    // similar to count subarry with sum k
    private static int subArrayOptimal(int[] arr, int target) {
        int idx = 0;
        int ans = 0;
        int prefixXor = 0;
        Map<Integer,Integer> prefixXorMap = new HashMap<>();

        // there exists a prefixxor =0, and it has a count of 1;
        prefixXorMap.put(0,1);
        while(idx<arr.length){

            // prefix xor
            prefixXor ^= arr[idx];

            // for target to exist x has to exist
            int x = prefixXor^target;

            if(prefixXorMap.containsKey(x))
                ans += prefixXorMap.get(x);

            // put the prefix xor in map
            prefixXorMap.put(prefixXor,prefixXorMap.getOrDefault(prefixXor,0)+1);
            idx++;

        }
        return ans;
    }
}
