import java.util.Scanner;

public class q2_nth_root_of_number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int n = sc.nextInt();
        int ans = getNthRoot(no, n); 
        System.out.println(n+"th root of "+ no +" is " + ans);
        sc.close();
    }

    private static int getNthPower(int no, int n){
        return (int)Math.pow(no, n);
    }


    private static int getNthRoot(int number, int n){
        int ed = number;
        int st = 1;
        while(st <= ed){
            int mid = ed - (ed -st)/2;
            int nthPower = getNthPower(mid, n);
            if(nthPower == number){
                return mid;
            }
            else if(nthPower  < number){
                st = mid+1;
            }
            else {
                ed = mid-1;
            }
        }
        return -1;
    }
    
}