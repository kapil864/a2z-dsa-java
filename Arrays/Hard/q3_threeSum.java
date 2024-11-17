import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class q3_threeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> sol = threeSumOptimal(arr);
        System.out.println("Triplets are: ");
        for (List<Integer> l : sol) {
            System.out.print(l + " ");
        }
        sc.close();
    }

    // brute force approach
    // TC = O(N^3)  not considering tC of sorting as only three elements need to be sorted
    //
    private static List<List<Integer>> threeSumBrute(int[] arr) {
        Set<List<Integer>> solSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (i != j && j != k && k != i) {
                        if (arr[i] + arr[j] + arr[k] == 0) {
                            List<Integer> tempList = new ArrayList<>();
                            tempList.add(arr[i]);
                            tempList.add(arr[j]);
                            tempList.add(arr[k]);
                            tempList.sort(null);
                            solSet.add(tempList);
                        }
                    }
                }
            }
        }
        return solSet.stream().toList();
    }

    // better approach using hashset
    // since sum of three numbers has to be zero
    // so sum of two numbers should be equal to neagtive of third
    // TC = O(N^2LogN) Log for inserting element in hashset
    private static List<List<Integer>> threeSumBetter(int[] arr) {
        Set<List<Integer>> solSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> tempSet = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                if (tempSet.contains(-(arr[i] + arr[j]))) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(arr[i]);
                    tempList.add(arr[j]);
                    tempList.add(-(arr[i] + arr[j]));
                    tempList.sort(null);
                    solSet.add(tempList);
                }
                tempSet.add(arr[j]);
            }
        }
        return solSet.stream().toList();
    }

    // optimal approach
    // sort the array
    // use three pointers (modifed two pointer)
    // one fixed -> while other two find elemets to add up to zero
    // TC = O(N^2) + O(NLogN)
    private static List<List<Integer>> threeSumOptimal(int[] arr) {

        List<List<Integer>> solList = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        while (i < arr.length) {
            if (i != 0 && arr[i] == arr[i - 1]) {
                i++;
                continue;
            }
            int j = i + 1;
            int k = arr.length - 1;
            while (j < k) {
                int tempSum = arr[i] + arr[j] + arr[k];
                if (tempSum == 0) {
                    List<Integer> triplet = Arrays.asList(arr[i], arr[j], arr[k]);
                    solList.add(triplet);
                    j++;
                    k--;
                    while (j < k && arr[j - 1] == arr[j]) {
                        j++;
                    }

                    while (j < k && arr[k + 1] == arr[k]) {
                        k--;
                    }
                } else if (tempSum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            i++;

        }
        return solList;
    }

}
