// similar to book allocation problem

import java.util.Arrays;
import java.util.Scanner;

public class q11_painter_partition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int painters = sc.nextInt();
        int st = Arrays.stream(arr).max().getAsInt();
        int ed = Arrays.stream(arr).sum();
        if (arr.length < painters) {
            System.out.println("Maximum minimum Pages alloted to students " + -1);
        }
        while (st <= ed) {
            int mid = st - (st - ed) / 2;
            if (getPaintersAlloted(arr, mid) <= painters) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        System.out.println("Partition alloted to painters " + st);
        sc.close();
    }

    public static int getPaintersAlloted(int[] books, int maxPages) {
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
