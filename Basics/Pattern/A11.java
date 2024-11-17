package Basics.Pattern;

import java.util.Scanner;

public class A11 {

    public static void createPattern(int N){
        for( int i=0; i<N; i++){
            for ( int j =0; j<=i; j++){
                if ( (i+j)%2 == 0){
                    System.out.print(1);
                }
                else{
                    System.out.print(0);
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
