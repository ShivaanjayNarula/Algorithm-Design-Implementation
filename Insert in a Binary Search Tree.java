/*
This is a leetcode question - 701
Was not in a mood to write the driver code
So bare with me
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
        {
            root = new TreeNode(val);
            return root;
        }
        if(root.val > val)
        {
            root.left = insertIntoBST(root.left, val);
        }
        if(root.val < val)
        {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
