/*
LeetCode - 235

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(root == nullptr)
        {
            return nullptr;
        }
        if(root == p || root == q)
        {
            return root;
        }
        TreeNode *left = lowestCommonAncestor(root->left, p, q);
        TreeNode *right = lowestCommonAncestor(root->right, p, q);
        if(left != nullptr && right != nullptr)
        {
            return root;
        }
        if(left != nullptr)
        {
            return left;
        }
        return right;
    }
};
