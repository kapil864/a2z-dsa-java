

import java.util.Scanner;

public class q4_maximumSubArrySum_KadensAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        // element that occurs more than n/2 times
        maxSubArraySum(arr);
        sc.close();
    }
    // brute force approach include calculating sum of every sub arry
    // return sum which is largest

    // optimal appraoch uses kaden's algo
    // take sum intitiallize it with zero
    // add next element
    // if sum is less than zero reset sum to zero
    // if sum is greater than maxSum update maxSum with sum.
    private static void maxSubArraySum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int arSt = -1;
        int arEd = -1;

        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                arSt = i;
            }
            sum+=arr[i];
            if (sum > maxSum){
                maxSum = sum;
                arEd = i;
            }

            if(sum < 0){
                sum = 0;
            }
        }   
        System.out.println("Maximum sum is "+maxSum+" and length of sub array is "+(arEd-arSt+1));
    }
}
