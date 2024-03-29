/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;                           5
 *         this.left = left;                       4   6
 *         this.right = right;                        3 7
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean dfs(TreeNode root, long min, long max) {
        if(root==null) 
            return true;
        if(root.val<=min || root.val>=max)
            return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}