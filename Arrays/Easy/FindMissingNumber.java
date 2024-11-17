package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindMissingNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println();
        System.out.println("Missing number is " + getMissingOptimal2(arr));
        sc.close();
    }

    private static int linearSearch(int[] arr, int no) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == no) {
                return i + 1;
            }
        }
        return -1;
    }

    // Brute force
    // Find use linear to search for elements
    private static int getMissingBrute(int[] arr) {
        for (int i = 0; i <= arr.length; i++) {
            if(linearSearch(arr, i) == -1){
                return i;
            }
        }
        return -1;
    }

    // through a diffrence between sum of numbers in array and num of N numbers
    private static long getMissingOptimal(int[] arr){
        long sum = 0;
        int len = arr.length;
        for( int i =0; i<len; i++){
            sum += arr[i];
        }
        long sumActual = (len*(len+1))/2;
        return sumActual-sum;
    }


    // using hash map of N keys,
    // traverse array and store count of each elemets in map, 
    // key with zero count is mising from array
    private static int getMissingBetter(int[] arr){
        int[] hash = new int[arr.length+1];
        for( int i =0; i<arr.length; i++){
            hash[arr[i]]++;
        }

        for( int i =0; i< hash.length; i++){
            if(hash[i] == 0){
                return i;
            }
        }
        return -1;
    }

    //using xor property
    // xor of two same number is zero
    // a^a = 0
    // a^0 = a
    private static int getMissingOptimal2( int[] arr){
        int xor1 = 0;
        int xor2 = 0;

        for( int i =0; i<arr.length; i++){
            xor1 = xor1^arr[i];
            xor2 = xor2^i;
        }

        xor2 = xor2^ arr.length;

        return xor1^xor2;
    }


}
