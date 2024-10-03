/*
Write a program that takes two positive integers as input and computes their Greatest Common Divisor (GCD).
The program should accept two integers greater than 0.
The output should be the GCD of the two integers, which is the largest integer that divides both numbers without leaving a remainder.
*Constraints:*
Input: 1 ≤ a, b ≤ 10⁶ (1 million)
 */

import java.util.*;
public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.print(a);
    }
}
