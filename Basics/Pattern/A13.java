package Basics.Pattern;

import java.util.Scanner;

public class A13 {

    public static void createPattern(int N) {
        int temp = 1;
        for( int i =0; i<N; i++){
            for( int j =0; j<= i; j++){
                System.out.print(temp + " ");
                temp++;
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
