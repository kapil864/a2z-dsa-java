import java.util.Arrays;
import java.util.Scanner;

public class q9_book_allocation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int students = sc.nextInt();
        int st = Arrays.stream(arr).max().getAsInt();
        int ed = Arrays.stream(arr).sum();
        if (arr.length < students) {
            System.out.println("Maximum minimum Pages alloted to students " + -1);
        }
        // this is a brute force approach and TC(O*(ed-st))
        // int ans = -1;
        // for (int i = st; i <= ed; i++) {
        //     if (getStudentsAlloted(arr, i) == students) {
        //         ans = i;
        //         break;
        //     }
        // }
        while ( st<= ed){
            int mid = st - (st -ed)/2;
            if ( getStudentsAlloted(arr, mid) <= students){
                 ed = mid  -1;
            }
            else {
                st = mid +1;
            }
        }
        System.out.println("Minimum maximum Pages alloted to students " + st);
        sc.close();
    }

    public static int getStudentsAlloted(int[] books, int maxPages) {
        int studentsAlloted = 1;
        int pagesAlloted = 0;
        for (int i : books) {
            if (pagesAlloted + i <= maxPages) {
                pagesAlloted += i;
            } else {
                studentsAlloted += 1;
                pagesAlloted = i;
            }
        }
        return studentsAlloted;
    }
}