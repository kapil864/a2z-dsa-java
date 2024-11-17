package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsSortedArray {

    private static boolean isAscending(List<Integer> arr){
        for(int i =0 ; i<arr.size()-1; i++){
            if(arr.get(i) > arr.get(i+1))
                return false;
        }
        return true;
    }

    private static boolean isDescending(List<Integer> arr) {
        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i) < arr.get(i + 1))
                return false;
        }
        return true;
    }

    private static boolean isSorted(List<Integer> arr){
        if(arr.get(0) < arr.get(arr.size()-1))
            return isAscending(arr);
        else
            return isDescending(arr);
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        for( int i = 0; i < length; i++){
            arr.add(sc.nextInt());
        }
        
        if(isSorted(arr)){
            System.out.println("Array is sorted.");
        }
        else{
            System.out.println("Array is not sorted.");
        }
        sc.close();
    }
}
