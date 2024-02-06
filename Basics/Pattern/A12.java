package Basics.Pattern;

import java.util.Scanner;

public class A12 {

    public static void createPattern(int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(j+1);
            }
            for(int j = 1; j<N-i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j<N-i; j++){
                System.out.print(" ");
            }
            for( int j = i; j>=0; j--){
                System.out.print(j+1);
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
