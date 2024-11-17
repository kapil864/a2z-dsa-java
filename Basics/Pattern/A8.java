package Basics.Pattern;

import java.util.Scanner;

public class A8 {
    public static void createPattern(int N) {
        for (int i = N-1; i >= 0; i--) {
            for (int j = 0; j < N - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            for (int j = 0; j <= i - 1; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        createPattern(N);
        sc.close();
    }
}
