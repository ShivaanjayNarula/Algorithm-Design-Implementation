/*
This consists of right side view of a Binary Tree, i.e. we have to return the right most node at each level
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, ans, 1);
        return ans;
    }
    void dfs(TreeNode root, List<Integer> ans, int i)
    {
        if(root == null)
        {
            return;
        }
        if(ans.size() < i)
        {
            ans.add(root.val);
        }
        dfs(root.right, ans, i+1);
        dfs(root.left, ans, i+1);
    }
}
