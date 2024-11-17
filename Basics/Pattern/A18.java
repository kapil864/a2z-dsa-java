package Basics.Pattern;

import java.util.Scanner;

public class A18 {
    public static void createPattern(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = i; j >= 0; j--) {
                System.out.print((char) (65 + N-j-1));
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
