package Basics.BasicMaths;

// Question 1
import java.util.Scanner;

public class CountDigits {

    public static void countDigits(int N) {

        int digits = 0;
        while (N != 0) {
            digits++;
            N = N / 10;

        }
        System.out.println("Digits :" + digits);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        countDigits(N);
        sc.close();
    }
}
