package BinarySearch.BS_On_Answers;

import java.util.Scanner;

public class q1_square_root {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int pos = getSquareRoot(no);
        System.out.println("Square Root is" + pos);
        sc.close();
    }

    private static int getSquareRoot(int no) {
        int ans = -1;
        int st = 0;
        int ed = no;
        while (st <= ed) {
            int mid = (st + ed) / 2;
            if ((long) mid * mid == no) {
                ans = mid;
                break;
            } else if ((long) mid * mid < no) {
                ans = mid;
                st = mid + 1;
            } else {
                ed = mid - 1;
            }
        }
        return ans;
    }
}
