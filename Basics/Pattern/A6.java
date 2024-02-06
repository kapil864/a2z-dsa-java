package Basics.Pattern;

import java.util.Scanner;

public class A6 {
    
    public static void createPattern(int N){
        for (int i = 0; i < N; i++) {
            for (int j = N; j > i; j--) {
                System.out.print(N-j+1);
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
