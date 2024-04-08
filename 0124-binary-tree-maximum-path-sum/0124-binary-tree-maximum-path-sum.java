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
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return Integer.MIN_VALUE;
        
        int left = 0, right = 0;
        
        if(root.left!=null)
            left = dfs(root.left);
        
        if(root.right!=null)
            right = dfs(root.right);
        
        int max = Math.max(root.val, Math.max(root.val+left+right, Math.max(root.val+left, root.val+right)));
        
        return Math.max(max, Math.max(maxPathSum(root.left), maxPathSum(root.right))); 
    }
    
    public int dfs(TreeNode root) {
        if(root==null)
            return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        int max = Math.max(left,right);
        
        return root.val + Math.max(max,0);
    }
}