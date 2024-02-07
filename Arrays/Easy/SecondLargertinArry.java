package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SecondLargertinArry {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        for( int i = 0; i < length; i++){
            arr.add(sc.nextInt());
        }
        
        int result = getSecondLargestElement(arr);
        System.out.println(result);
        System.out.println(betterApproach(arr));
        sc.close();
    }

    private static int getSecondLargestElement(List<Integer> arr) {
        arr.sort(null);
        if (arr.size() < 2){
            return -1;
        }
        return arr.get(arr.size()-2);
    }


    // Create two variables
    // one for storing largest and another for second largest
    private static int betterApproach(List<Integer> arr){
        int largest = arr.get(0);
        int secondLargest = -1;

        for( int i=0 ; i< arr.size(); i++){
            if (arr.get(i) > largest){
                secondLargest = largest;
                largest = arr.get(i);
            }
            else if (arr.get(i) < largest && arr.get(i) > secondLargest) {
                secondLargest = arr.get(i);
            }
        }

        return secondLargest;
    }
}
