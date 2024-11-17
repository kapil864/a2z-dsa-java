

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class q1_twoSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        int[] sol = twoSumOptimal(arr, sum);
        System.out.println();
        System.out.println("Index of array are  " + sol[0] + " and " + sol[1] + ".");
        sc.close();
    }

    private static int[] twoSumBrute(int[] arr, int sum) {
        int[] sol = { -1, -1 };
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i != j && arr[i] + arr[j] == sum) {
                    sol[0] = i;
                    sol[1] = j;
                }
            }
        }
        return sol;
    }

    // using hashmap
    // store store elements in hashmap
    // if sum of two number is k then there exists a number k-no, and no
    private static int[] twoSumBetter(int[] arr, int sum) {
        int[] sol = { -1, -1 };
        Map<Integer, Integer> solMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            // before putting in map check if no already exists or not
            // so as to avoid cases like [3,3] with target sum as 6.
            if (!solMap.containsKey(arr[i])) {
                solMap.put(arr[i], i);
            }
            if (solMap.containsKey(sum - arr[i]) && i != solMap.get(sum - arr[i])) {
                sol[0] = i;
                sol[1] = solMap.get(sum - arr[i]);
            }
        }
        return sol;
    }

    // optimal approach
    // using two pointers 
    // make a new array with elements and it's indices as one element {element,idex};
    // sort the new array according to first element
    // use two pointers one at the end other at the start
    // increase start and decrease ed
    // till their sum is equal to required sum.
    // and return their indices.
    private static int[] twoSumOptimal(int[] arr,int sum){
        int[] sol = { -1, -1 };
        List<Integer> tempArry = new ArrayList<>();
        for (int i : arr) {
            tempArry.add(i);
        }
        tempArry.sort(null);
        int st = 0; 
        int ed = arr.length-1;
        while(st<ed){
            int tempSum = tempArry.get(st) + tempArry.get(ed);
            if(tempSum < sum ){
                st++;
            }
            else if(tempSum > sum){
                ed--;
            }
            else{
                sol[0] = tempArry.get(st);
                sol[1] = tempArry.get(ed);
                return sol;
            }
        }
        return sol;
    }

}
