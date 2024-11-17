package Basics.BasicMaths;

import java.util.Scanner;

public class GCDorHCF {

    public static int calculateHCF(int a, int b) {
        int GCD = a > b ? b : a;
        while (GCD > 1) {
            if (a % GCD == 0 && b % GCD == 0) {
                return GCD;
            }
            GCD--;
        }
        return GCD;

    }

    public static int gcdByEuclidsTheorem(int a, int b){
        int larger = a > b ? a : b;
        int smaller = a > b ? b : a;

        if (larger==0){
            return smaller;
        }
        if(smaller == 0){
            return larger;
        }
        int temp = Math.abs(larger-smaller);
        return gcdByEuclidsTheorem(temp, smaller);
    }

    public static int gcdByEuclidsTheoremOpti(int a, int b){
        if (a==0){
            return b;
        }
        if(b == 0){
            return a;
        }
        int larger = a > b ? a : b;
        int smaller = a > b ? b : a;
        return gcdByEuclidsTheoremOpti(smaller, larger%smaller);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("GCD of " + a + " and " + b + " is " + gcdByEuclidsTheoremOpti(a, b));
        sc.close();
    }
}
