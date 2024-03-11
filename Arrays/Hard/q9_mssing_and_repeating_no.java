import java.util.Scanner;

public class q9_mssing_and_repeating_no {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println();
        int[] ans = findMissingRepeatingOptimal2(arr);
        System.out.println("Repeating no: " + ans[0] + " Missing no: " + ans[1]);
        sc.close();
    }

    // count occurances of each element if occurrence is 2 it is a repeating number
    // else if occurrence is zero then it is a missing number
    // TC = o(N^2)
    // SC = o(1)
    private static int[] findMissingRepeatingBrute(int[] arr) {
        int[] ans = new int[2];
        for (int i = 1; i <= arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    count++;

                }
            }
            if (count == 2) {
                ans[0] = i;
            } else if (count == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }

    // better approach will use hashing
    // TC = O(2N)
    // SC = O(N)
    private static int[] findMissingRepeatingBetter(int[] arr) {
        int[] ans = new int[2];
        int[] hash = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 2) {
                ans[0] = i;
            } else if (hash[i] == 0) {
                ans[1] = i;
            }
        }
        return ans;
    }

    // Optimal approach 1
    // Using math
    // calculate sum of array and N number
    // calculate sum of squares of array and N numbers
    // create two equations
    // let x be repeating number ans y be missing number
    // TC = o(N)
    // SC = O(1)
    private static int[] findMissingRepeatingOptimal1(int[] arr) {
        int[] ans = new int[2];
        int n = arr.length;
        long x = 0;
        long y = 0;
        long sumOfArray = 0;
        long sumOfArraySquares = 0;
        long sumOfN = (n * (n + 1)) / 2;
        long sumOfNSquares = (n * (n + 1) * (2 * n + 1)) / 6;
        for (int i = 0; i < n; i++) {
            sumOfArray += arr[i];
            sumOfArraySquares += arr[i] * arr[i];
        }

        // find x-y
        long val1 = sumOfArray - sumOfN;

        // find x^2 - y^2
        long val2 = sumOfArraySquares - sumOfNSquares;

        // find x +y = (x^2 - y^2)/(x -y)
        val2 = val2 / val1;

        x = (val1 + val2) / 2;
        y = x - val1;

        ans[0] = (int) x;
        ans[1] = (int) y;
        return ans;

    }

    // optimal method 2
    // using xor
    // calculate xor for array and xor of N numbers, xor them
    // find the position of right most differentiating bit (x).
    // from an imaginary array with elements from given array and 1-N elements
    // divide elements in group of two.
    // one with having (x) bit set as 1 and other with 0
    // xor elements in each group
    // there will be a missing or repeating element in either of the xor done in
    // last group
    // check for confirmation using a single loop
    // TC = O(N)
    // SC = O(1)
    private static int[] findMissingRepeatingOptimal2(int[] arr) {

        int arrayXor = 0;

        // calculate xor of array
        for (int i = 0; i < arr.length; i++) {
            arrayXor ^= arr[i];
            arrayXor ^= i + 1;
        }

        // no with position of rightmost differentiating bit
        int pos = (arrayXor & ~(arrayXor - 1));

        // grouping numbers
        int zero = 0;
        int one = 0;
        for (int i = 0; i < arr.length; i++) {

            if ((arr[i] & pos) != 0) {
                one^=arr[i];
            }
            else{
                zero^=arr[i];
            }
        }

        for(int i =1; i<=arr.length; i++){
            if((i&pos)!=0){
                one^=i;
            }
            else{
                zero^=i;
            }
        }

        // check for which is occurring twice
        int counter = 0;
        for(int i =0; i<arr.length; i++){
            if(arr[i] == one){
                counter++;
            }
        }
        if (counter==2){
            return new int[] {one, zero};
        }
        return new int[] { zero, one };
    }
}
