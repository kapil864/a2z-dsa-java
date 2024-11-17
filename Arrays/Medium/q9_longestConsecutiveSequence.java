import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class q9_longestConsecutiveSequence {
    public static void main(String[] args) {
        {
            Scanner sc = new Scanner(System.in);
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            // element that occurs more than n/2 times
            int sol = sequenceOptimal2(arr, size);

            System.out.print(sol + " ");

            sc.close();
        }
    }

    private static boolean linerSearch(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (k == arr[i]) {
                return true;
            }
        }
        return false;
    }

    // take a element and perform a linear search to find the next next element
    // calculate the the number elements in each iteration
    // and return the one with largest length
    // TC = O(N^2) SC= O(1)
    private static int sequenceBrute(int[] arr, int size) {
        int len = 0;
        for (int i = 0; i < size; i++) {
            int count = 1;
            int element = arr[i] + 1;
            while (linerSearch(arr, element)) {
                count++;
                element++;
            }
            len = Integer.max(count, len);
        }
        return len;
    }

    // optimal(1) better approach
    // sort the array
    // count length of sequence which is consecutive
    // i.e for a element to be consecutive there has to exist a number which is 1
    // less than current
    // TC = N(LogN)+N, N(LogN) for sorting array
    // SC = O(1)

    private static int sequenceOptimal1(int[] arr, int size) {
        List<Integer> tempArr = new ArrayList<>();
        for (int i : arr) {
            tempArr.add(i);
        }
        tempArr.sort(null);
        int len = 0;
        int lastMin = Integer.MIN_VALUE;
        int count = 1;
        int idx = 0;
        while (idx < tempArr.size()) {
            if (lastMin + 1 == tempArr.get(idx)) {
                count++;
                lastMin = tempArr.get(idx);
            } else if (tempArr.get(idx) != lastMin) {
                count = 1;
                lastMin = tempArr.get(idx);
            }
            idx++;
            len = Integer.max(count, len);
        }
        return len;
    }

    // optimal 2
    // another method uses set
    // iterate over array and insert each element in set
    // now check for each element (i) in set if(i -1) exists.
    // if it exists then it means a this element(i) is not starting point of
    // sequence
    // if i-1 do not exists then i must be stating point.
    // we check for consecutive elements in set.
    // if set (ordered set) operations take logN time
    // TC = NLogN+N;
    // if set operations take o(1), if set is unordered (in C++)
    // TC = 3N;
    // SC = O(N) storing elements in set.
    private static int sequenceOptimal2(int[] arr, int size){
        Set<Integer> tempSet = new HashSet<>();
        for( int i :arr){
            tempSet.add(i);
        }

        int len = 1;
        for(int i : tempSet){
            if (!tempSet.contains(i-1)){
                int count =1;
                int curr = i;
                while(tempSet.contains(curr+1)){
                    count++;
                    curr++;
                }
                len = Integer.max(count, len);
            }
        }
        return len;
    }

}
