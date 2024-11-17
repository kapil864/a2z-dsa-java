import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class q4_four_sum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        List<List<Integer>> sol = fourSumOptimal(arr, target);
        System.out.println("Quads are: ");
        for (List<Integer> l : sol) {
            System.out.print(l + " ");
        }
        sc.close();
    }

    // brute force
    // use four loops
    // check if sum of four elements is equal to target element
    private static List<List<Integer>> fourSumBrute(int[] arr, int target) {
        Set<List<Integer>> quad = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int l = k + 1; l < arr.length; l++) {
                        long sum = arr[i] + arr[j] + arr[k] + arr[l];
                        if (sum == target) {
                            List<Integer> quadTuples = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                            quadTuples.sort(null);
                            quad.add(quadTuples);
                        }
                    }
                }
            }
        }
        return quad.stream().toList();
    }

    // better appraoach
    // since a+b+c+d = target
    // so look for element which is equal to target-d
    // this will reduce time complexity from N^4 to n^3log(no of elemets in set)
    private static List<List<Integer>> fourSumBetter(int[] arr, int target) {
        Set<List<Integer>> quad = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Set<Long> tempSet = new HashSet<>();
                for (int k = j + 1; k < arr.length; k++) {
                    long sum = arr[i] + arr[j];
                    sum += arr[k];
                    if (tempSet.contains(target - sum)) {
                        List<Integer> quadTuples = Arrays.asList(arr[i], arr[j], arr[k], (int) (target - sum));
                        quadTuples.sort(null);
                        quad.add(quadTuples);
                    }
                    tempSet.add((long) arr[k]);
                }
            }
        }
        return quad.stream().toList();
    }

    // using a apprach similar to 3 sum optimal solution
    // using four pointers
    // keep two pointers fixed and check for elemets between rest oof two elements
    private static List<List<Integer>> fourSumOptimal(int[] arr, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i != 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = arr.length - 1;
                while (k < l) {
                    long sum = arr[i] + arr[j];
                    sum += arr[k];
                    sum += arr[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> solList = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        sol.add(solList);
                        k++;
                        l--;
                        while (k < l && arr[k - 1] == arr[k]) {
                            k++;
                        }
                        while (k < l && arr[l + 1] == arr[l]) {
                            l--;
                        }
                    }
                }
            }
        }
        return sol;
    }

}
