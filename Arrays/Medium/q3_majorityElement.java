package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class q3_majorityElement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        // element that occurs more than n/2 times
        int sol = majorityElementOptimal(arr);
        System.out.println();
        System.out.println(" Majority element is " + sol+".");
        sc.close();
    }

    // calculate count of each element if element is found more than n/2 times then
    // return it
    private static int majorityElementBrute(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            if(count>size/2){
                return arr[i];
            }
        }
        return -1;
    }

    //using hashmap to store frequency of elements in array
    // return element which has a frequency greater than N/2
    private static int majorityElementBetter(int[] arr){

        int size = arr.length;
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int i : arr){
            countMap.put(i, countMap.getOrDefault(i, 0)+1 );
        }
        for(int itr : countMap.keySet()){
            if( countMap.get(itr) > size/2){
                return itr;
            }
        }
        return -1;

    }

    // using moore's algo
    // get majority element, and confirm if it is a majority element.

    private static int majorityElementOptimal(int[] arr){
        int majority = arr[0];
        int size = arr.length;
        int count =1;
        for(int i =1; i<size ; i++){
            if(arr[i]==majority){
                count++;
            }
            else if(arr[i] != majority && count >0){
                count--;
            }
            else{
                majority = arr[i];
                count = 1;
            }
        }
        int countCheck = 0;

        // ussing this loop to verify that majority element is actually majority element
        for( int i =0; i<size; i++){
            if(arr[i]==majority){
                countCheck++;
            }
        }
        if(countCheck > size/2){
            return majority;
        }
        return -1;
    }
}
