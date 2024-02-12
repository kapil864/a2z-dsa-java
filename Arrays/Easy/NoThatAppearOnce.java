package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoThatAppearOnce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("No that appear once is "+ findNoOptimal(arr));
        
        sc.close();
    }


    // using hashmap
    // store count of elemets and return the element whose count is 1
    private static int findNoBrute(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i =0; i<arr.length; i++){
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }

        for( int i : freq.keySet()){
            if(freq.get(i) == 1){
                return i;
            }
        }
        return -1;
        
    }

    // use xor
    // as a^a = 0
    // and a^0 = a
    private static int findNoOptimal(int[] arr){
        int xor = 0;
        for( int i =0; i<arr.length; i++){
            xor ^= arr[i];
        }
        return xor;
    }


}
