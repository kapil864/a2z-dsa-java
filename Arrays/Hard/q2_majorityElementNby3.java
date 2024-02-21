package Arrays.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class q2_majorityElementNby3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // element that occurs more than n/3times
        List<Integer> sol = majorityElementOptimal(arr);
        System.out.println();
        System.out.println("Majority elements are ");
        for (Integer integer : sol) {
            System.out.print(integer + " ");
        }
        sc.close();
    }

    // make a count for each element and element with max count will be returned
    private static List<Integer> majorityElementBrute(int[] arr) {
        Set<Integer> sol = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (j != i) {
                    count++;
                }
            }
            if (count > arr.length / 3)
                sol.add(arr[i]);
        }
        if (sol.isEmpty()) {
            sol.add(-1);
        }
        return sol.stream().toList();
    }

    // using hash map to store count of each element
    // TC = O(2N), SC = O(N)
    private static List<Integer> majorityElementBetter(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();

        for (Integer integer : countMap.keySet()) {
            if (countMap.get(integer) > arr.length / 3) {
                ans.add(integer);
            }
        }
        if (ans.isEmpty())
            ans.add(-1);
        return ans;
    }

    // modified boyer-mooore's algo (moore's algo)
    private static List<Integer> majorityElementOptimal(int[] arr) {
        int count1 = 0;
        int count2 = 0;
        int e1 = Integer.MIN_VALUE;
        int e2 = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (count1 == 0 && arr[i] != e2) {
                count1++;
                e1 = arr[i];
            } else if (count2 == 0 && arr[i] != e1) {
                count2++;
                e2 = arr[i];
            } else if (arr[i] == e1) {
                count1++;
            } else if (arr[i] == e2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int ckcount1 = 0;
        int ckcount2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (e1 == arr[i]) {
                ckcount1++;
            } else if (e2 == arr[i]) {
                ckcount2++;
            }
        }

        if (ckcount1 > arr.length / 3)
            ans.add(e1);
        if (ckcount2 > arr.length / 3)
            ans.add(e2);
        return ans;
    }

}
