import java.util.Scanner;

public class q10_count_inversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int inversions = countInversionOptimal(arr);
        System.out.println("Total number of inversion are : "+inversions);
        sc.close();
    }
    
    // brute force approach
    // TC = O(N^2)
    private static int getInversionBrute(int[] arr) {
        int inversions = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j =i+1; j<arr.length; j++){
                if(i < j && arr[j] < arr[i]){
                    inversions++;
                }
            }
        }
        return inversions;
    }

    // optimal approach
    // using merge sort algo
    private static int countInversionOptimal(int[] arr){
        return mergeSort(arr, 0, arr.length-1);
    }


    private static int merge(int[] arr, int st, int ed, int mid){
        int count = 0;
        int size = ed - st +1;
        int[] tempArr = new int[size];

        int left = st;
        int right = mid+1;
        int tempArrIdx = 0;
        while( left <= mid && right<= ed){

            // since here i < j and arr[i] < arr[j], so there is no inversion
            if(arr[left]<= arr[right]){
                tempArr[tempArrIdx] = arr[left];
                left++;
            }

            // since here i<j and arr[i] > arr[j], so there will be inversions
            // since both the arrays are sorted then no of inversion will be mid-left+1
            else{
                count += mid-left +1;
                tempArr[tempArrIdx] = arr[right];
                right++;
            }
            tempArrIdx++;
        }

        while (left<= mid) {
            tempArr[tempArrIdx] = arr[left];
            left++;
            tempArrIdx++;
        }

        while(right<= ed){
            tempArr[tempArrIdx] = arr[right];
            right++;
            tempArrIdx++;
        }

        for( int i =  0 ; i<tempArr.length; i++){
            arr[st+i]= tempArr[i];
        }

        return count;

    }

    private static int mergeSort(int[] arr, int st, int ed){
        int count = 0;
        if (st >= ed){
            return count;
        }
        int mid = (st+ed)/2;
        count += mergeSort(arr, st, mid);
        count += mergeSort(arr, mid+1, ed);
        count += merge(arr, st, ed, mid);
        return count;
    }
    
}
