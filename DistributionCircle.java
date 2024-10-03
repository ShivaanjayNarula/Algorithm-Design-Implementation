/*
*Description*
You are given n items to distribute in a circle, starting at position k. You need to determine the final position of the last item distributed.
The items are distributed in a circular manner, meaning after reaching the last position, the distribution wraps around to the first position.
You are given n (number of items), m (total positions in the circle), and k (starting position) as inputs.
You need to output the position where the last item is placed.

*Constraints:*
1 ≤ n ≤ 10⁹
1 ≤ m ≤ 10⁹
1 ≤ k ≤ m
 */

import java.util.*;
public class DistributionCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int ans = (k + n - 1) % m;
        if(ans == 0)
        {
            ans = m;
        }
        System.out.print(ans);
    }
}