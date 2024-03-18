import java.util.Scanner;

public class q12_maximum_product_Subarrray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        long maxProduct = maxProductOptimal(arr);
        System.out.println("Maximum Product is : " + maxProduct);
        sc.close();
    }

    // TC = O(N^2)
    private static long maxProductSubArrayBrute(int[] arr) {
        long maxProduct = 1;
        for (int i = 0; i < arr.length; i++) {
            long product = 1;
            for (int j = i; j < arr.length; j++) {
                product *= arr[j];
                maxProduct = Long.max(product, maxProduct);
            }
        }
        return maxProduct;
    }

    // Optimal approach
    // Either the answer will be in suffix or prefix product
    // TC = O(N)
    // SC= O(1)
    private static long maxProductOptimal(int[] arr){
        long ans = Long.MIN_VALUE;
        long prefixProduct = 1;
        long suffixProduct= 1;
        for (int i =0; i<arr.length; i++)
        {
            if(prefixProduct == 0){
                prefixProduct = 1;
            }
            if(suffixProduct == 0){
                suffixProduct = 1;
            }
            prefixProduct *= arr[i];
            suffixProduct *= arr[arr.length-1-i];
            ans = Long.max(ans, Long.max(prefixProduct, suffixProduct));
        }
        return ans;
    }
}
