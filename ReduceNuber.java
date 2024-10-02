// You are given an integer n.
//* On each step, you may subtract one of the digits from the number.
//How many steps are required to make the number equal to 0?
//Input
//Input Format
//The first line contains the number of testcases, T
//For each testcase:
//* The first and only contains the number N
//Constraints
//1<=T<=5
//1<=N<=50
//Output
//For each testcase, print the minimum number of steps.

import java.util.*;
public class ReduceNuber{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = solve(n);
        System.out.print(ans);
    }
    public static int solve(int n){
        int ans = 0;
        while(n > 0)
        {
            int num = maxi(n);
            n -= num;
            ans++;
        }
        return ans;
    }
    public static int maxi(int n){
        int maxi = 0;
        while(n > 0)
        {
            int digit = n % 10;
            maxi = Math.max(maxi, digit);
            n /= 10;
        }
        return maxi;
    }
}