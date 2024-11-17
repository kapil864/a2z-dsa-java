package Basics.Pattern;

import java.util.Scanner;

public class A21 {

    public static void createPattern(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
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
