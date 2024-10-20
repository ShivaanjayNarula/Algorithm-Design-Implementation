/*
This consists of left side view of a Binary Tree, i.e. we have to return the left most node at each level
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
  public List<Integer> leftSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    helper(root, ans, 1);
    return ans;
  }

  void helper(TreeNode root, List<Integer> ans, int i) {
    if (root == null)
    {
      return;
    }
    if(ans.size() < i)
    {
      ans.add(root.val);
    }
    helper(root.left, ans, i + 1);
    helper(root.right, ans, i + 1);
  }
}
