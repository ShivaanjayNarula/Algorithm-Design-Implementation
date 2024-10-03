/*
Write a program that takes a positive integer as input and returns its prime factorization.
The program should accept an integer greater than 1.
The output should list all the prime factors of the input integer, including their exponents.
The prime factors should be printed in ascending order.

*Constraints:*
Input: 2 ≤ n ≤ 10⁶ (1 million)

*Challenge:*
Optimize the algorithm so it can handle large numbers efficiently.
 */

import java.util.*;
public class PrimeFactorisation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        ans = prime(n);
        System.out.print(ans);
    }
    public static ArrayList<Integer> prime(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2; i <= n; i++) {
            while(n % i == 0) {
                ans.add(i);
                n /= i;
            }
        }
        return ans;
    }
}