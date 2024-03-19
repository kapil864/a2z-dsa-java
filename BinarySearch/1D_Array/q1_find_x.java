import java.util.Scanner;

public class q1_find_x {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int pos = binarySearch(arr, key);
        System.out.println("Position of "+key+" is : " + pos);
        sc.close();
    }

    private static int binarySearch(int[] arr, int key) {
        int st = 0;
        int ed = arr.length -1;
        while(st<=ed){
            int mid = (st+ed)/2;
            if(arr[mid]==key){
                return mid;
            }
            else if(arr[mid] < key){
                st = mid+1;
            }
            else{
                ed = mid-1;
            }
        }
        return -1;
    }
}
