package Basics.BasicMaths;

// Question 2
import java.util.Scanner;

public class ReverseANumber {
    public static int reverse(int N){
        int rev = 0;
        while(N !=0 ){
            int remainder = N%10;
            rev = 10*rev + remainder;
            N = N/10;
        }
        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.printf("Reverse of %d is : %d",N,reverse(N));
        sc.close();
    }
}
