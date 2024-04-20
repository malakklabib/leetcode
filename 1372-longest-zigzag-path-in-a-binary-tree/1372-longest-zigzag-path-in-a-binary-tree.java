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
    int ans;
    public int longestZigZag(TreeNode root) {
        dfs(root.left, true, 1);
        dfs(root.right, false, 1);
        return ans;
    }
    public void dfs(TreeNode node, boolean wasLeft, int path){
        if(node==null)
            return;
        
        ans = Math.max(ans, path);
        
        if(wasLeft){
            dfs(node.right, false, path+1);
            dfs(node.left, true, 1);
        }
        else{
            dfs(node.left, true, path+1);
            dfs(node.right, false, 1);
        }
    }
}