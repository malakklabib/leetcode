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
    List<Integer> nodes;
    public int getMinimumDifference(TreeNode root) {
        nodes = new ArrayList<Integer>();
        dfs(root);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < nodes.size(); i++) 
            min = Math.min(min, Math.abs(nodes.get(i)-nodes.get(i-1)));
        return min;
    }
    
    public void dfs(TreeNode node) {
        if(node==null)
            return;
        dfs(node.left);
        nodes.add(node.val);
        dfs(node.right);
    }
}