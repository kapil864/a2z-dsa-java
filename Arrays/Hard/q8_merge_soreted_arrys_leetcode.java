import java.util.Scanner;


// merge the two arrays to array 1
// Link : https://leetcode.com/problems/merge-sorted-array/solutions/3958223/java-runtime-0-ms-beats-100-o-m-n/
public class q8_merge_soreted_arrys_leetcode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();
        int[] arr1 = new int[size1+size2];
        int[] arr2 = new int[size2];
        for (int i = 0; i < size1+size2; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        mergeSortedOptimal(arr1, arr2, size1, size2);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    // take two pointers and compare elements starting from m-1 and n-1 and place them at correct position
    private static void mergeSortedOptimal(int[] arr1, int[] arr2, int m, int n) {
        int pt1 = m-1;
        int pt2 = n-1;

        // pointer to keep track of merged position
        int pMerge = m+n-1;

        while(pt2>=0){
            if(pt1 >= 0 && arr1[pt1] > arr2[pt2]){
                arr1[pMerge] = arr1[pt1];
                pMerge--;
                pt1--;
            }
            else{
                arr1[pMerge] = arr2[pt2];
                pMerge--;
                pt2--;
            }
        }
    }
}
