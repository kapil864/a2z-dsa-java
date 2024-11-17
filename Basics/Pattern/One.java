package Basics.Pattern;

import java.util.Scanner;

public class One {

    public static void createPattern(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
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
