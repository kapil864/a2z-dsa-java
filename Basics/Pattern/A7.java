// yet to be worked upon

package Basics.Pattern;

import java.util.Scanner;

public class A7 {
    public static void createPattern(int N){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N-i; j++) {
                System.out.print(" ");
            }
            for( int j = 0; j<=i; j++){
                System.out.print("*");
            }
            for( int j = 0; j<=i-1; j++){
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
