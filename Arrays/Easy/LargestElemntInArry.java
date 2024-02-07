package Arrays.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargestElemntInArry {

    public static int getLargestElement(List<Integer> arr){
        int idx = 0;
        for(int i =0 ; i<arr.size(); i++){
            if(arr.get(idx) <arr.get(i))
                idx = i;
        }
        return idx;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        for( int i = 0; i < length; i++){
            arr.add(sc.nextInt());
        }
        
        int result = getLargestElement(arr);
        System.out.println(arr.get(result));
        sc.close();
    }
}
