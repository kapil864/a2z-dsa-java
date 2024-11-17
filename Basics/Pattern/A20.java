package Basics.Pattern;

import java.util.Scanner;

public class A20 {

    public static void createPattern(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i >= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            for (int j = N; j >= 0; j--) {
                if (i >= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
        for (int i = N; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (i >= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            for (int j = N; j >= 0; j--) {
                if (i >= j) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        createPattern(N);
        sc.close();
    }
}
