package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaxLenSubArrySumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        System.out.println();
        System.out.println("Length of maximum sub-array is  " + maxLenSubArryOptimal(arr, sum));

        sc.close();
        
    }

    // brute force find all subarrays and caluculate sum of each subarray
    // if sum matches that of subarry then return lenght of that subarry
    private static int maxLenSubArryBrute(int[] arr, int sum) {
        int size = arr.length;
        int maxLen = 0;
        for (int i = 0; i < size; i++) {
            long tempSum = 0;
            for (int j = i; j < size; j++) {
                tempSum += arr[j];
                if (tempSum == sum && maxLen < j - i + 1) {
                    maxLen = j - i + 1;
                }
            }
        }
        return maxLen;
    }

    // optimal approach if all elements are integers including -ve zeros and
    // positives.
    // better if elements are non negative
    // take a element and from that element calculate sum (x) up-to that element and
    // store it in hashmap.
    // check from that elemnt if there exists an array with sum k then there should
    // exist a subarray with sum x-k.
    private static int maxLenSubArryBetter(int[] arr, int sum) {
        int maxLen = 0;
        int tempSum = 0;
        Map<Integer, Integer> solMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            tempSum += arr[i];
            if (tempSum == sum) {
                maxLen = i + 1;
            }
            if (solMap.get(tempSum) == null) {
                solMap.put(tempSum, i);
            }

            if (solMap.get(tempSum - sum) != null && maxLen < i - solMap.get(tempSum - sum) + 1) {
                maxLen = i - solMap.get(tempSum - sum) + 1;
            }
        }
        return maxLen;
    }

    // two pointer approach 
    // best of elements are non negative
    private static int maxLenSubArryOptimal(int[] arr, int sum){
        int tempSum = 0;
        int left =0;
        int right = 0;
        int arrLen = arr.length;
        int len = 0;
        while (right<arrLen) {
            tempSum += arr[right];

            if(tempSum==sum && len< right - left + 1){
                len = right-left+1;
            }

            while(tempSum >sum){
                tempSum -= arr[left];
                left++;
            }

            right++;

            
        }
        return len;
    }

}
