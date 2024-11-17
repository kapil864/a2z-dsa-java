package Arrays.Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UnionOfSoretedArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int size2 = sc.nextInt();
        int[] arr2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println();
        List<Integer> unionArry = getUnion3(arr, arr2);
        for (int i : unionArry) {
            System.out.print(i+" ");
        }
        sc.close();
    }


    // using two set (ordered set)
    private static List<Integer> getUnion(int[] arr, int[] arr2){
        Set<Integer> unionSet = new HashSet<>();
        List<Integer> unionList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            unionSet.add(arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            unionSet.add(arr2[i]);
        }

        for( int it : unionSet){
            unionList.add(it);
        }

        return unionList;
    }


    // using HashMap (orderd hash map)
    private static List<Integer> getUnion1(int[] arr, int[] arr2) {
        Map<Integer, Integer> elements = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            elements.put(arr[i], elements.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < arr2.length; i++) {
            elements.put(arr2[i], elements.getOrDefault(arr2[i], 0) + 1);
        }
        List<Integer> Union = new ArrayList<Integer>();
        for( int itr : elements.keySet()){
            Union.add(itr);
        }
        return Union;
    }

    // using two pointer
    private static List<Integer> getUnion3(int[] arr, int[] arr2){
        List<Integer> union = new ArrayList<>();
        int ptr1 =0;
        int ptr2 =0;

        while(ptr1 < arr.length && ptr2 < arr2.length){
            if(arr[ptr1]<arr2[ptr2]){
                union.add(arr[ptr1]);
                ptr1++;
            }
            else{
                union.add(arr2[ptr2]);
                ptr2++;
            }
        }

        while(ptr1 < arr.length){
            union.add(arr[ptr1]);
            ptr1++;
        }
        while(ptr2 < arr2.length){
            union.add(arr2[ptr2]);
            ptr2++;
        }

        return union;
    }
}
