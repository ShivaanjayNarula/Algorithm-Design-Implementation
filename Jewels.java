/*
LeetCode - 771
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0
 */

import java.util.*;
public class Jewels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jewels = sc.nextLine();
        String stones = sc.nextLine();
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for(char ch : jewels.toCharArray()) {
            set.add(ch);
        }
        for(char ch : stones.toCharArray()) {
            if(set.contains(ch)) {
                ans++;
            }
        }
        System.out.print(ans);
    }
}