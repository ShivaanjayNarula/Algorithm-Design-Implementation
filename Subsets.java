/*
LeetCode - 78
Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
 */
import java.util.*;
public class Subsets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []nums = new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        helper(nums, 0, new ArrayList<>(), ans);
        System.out.println(ans);
    }
    private static void helper(int[] nums, int id, List<Integer> temp, List<List<Integer>> ans) {
        int n = nums.length;
        if(id == n) {
            return;
        }
        for (int i = id; i < n; i++) {
            temp.add(nums[i]);
            ans.add(new ArrayList<>(temp));
            helper(nums, i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }
}