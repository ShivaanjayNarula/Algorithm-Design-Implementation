/*
LeetCode - 103

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int level = 0;
        helper(root, level, ans);
        int n = ans.size();
        for(int i = 0; i < n; i++)
        {
            if(i % 2 != 0)
            {
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }
    public void helper(TreeNode root, int level, List<List<Integer>> ans)
    {
        if(root == null)
        {
            return;
        }
        if(level == ans.size())
        {
            ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.val);
        helper(root.left, level+1, ans);
        helper(root.right, level+1, ans);
    }
}
