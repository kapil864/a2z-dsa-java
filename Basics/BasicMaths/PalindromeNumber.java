package Basics.BasicMaths;

import java.util.Scanner;

// Question 3
// check wether the given number is palindrome or not
public class PalindromeNumber {

    public static boolean isPalindromeNumber(int N){
        int temp = N;
        int rev = 0;
        while (N != 0) {
            int remainder = N % 10;
            rev = 10 * rev + remainder;
            N = N / 10;
        }
        if (temp == rev) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.print("Palindrome " + isPalindromeNumber(N));
        sc.close();
    }
}
