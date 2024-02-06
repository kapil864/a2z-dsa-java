package Basics.BasicRecusrsion;

import java.util.Scanner;

public class StringPalindrome {
    public static boolean isPalindrome(String s) {

        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(s.length() - 1))
                return true;
            else
                return false;
        }
        s = s.substring(1, (s.length() - 1));
        return isPalindrome(s);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Is palindrome : " + isPalindrome(s));
        sc.close();
    }
}
