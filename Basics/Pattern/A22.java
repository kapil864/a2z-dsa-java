package Basics.Pattern;

import java.util.Scanner;

public class A22 {

    public static void createPattern(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i <= j) {
                    System.out.print(N - i);
                } else {
                    System.out.print(N - j);
                }
            }
            for (int j = N-1; j >0; j--) {
                if (i < j) {
                    System.out.print(N-i);
                } else {
                    System.out.print(N-j+1);
                }
            }
            System.out.println();
        }
        for (int i = N-2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (i <= j) {
                    System.out.print(N - i);
                } else {
                    System.out.print(N - j);
                }
            }
            for (int j = N-1; j >0; j--) {
                if (i < j) {
                    System.out.print(N-i);
                } else {
                    System.out.print(N-j+1);
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
