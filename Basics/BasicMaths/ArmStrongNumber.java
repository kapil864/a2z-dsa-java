package Basics.BasicMaths;

import java.util.Scanner;

public class ArmStrongNumber {
    public static boolean isArmsStrong(int N) {
        int sum = 0;
        int temp = N;
        while (temp > 0) {
            sum += Math.pow(temp % 10, 3);
            temp /= 10;
        }
        if (sum == N)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println("Given number is an Armstrong number :--: " + isArmsStrong(N));
        sc.close();
    }
}
