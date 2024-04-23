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
    Map<TreeNode, Integer> memo = new HashMap();
    public int rob(TreeNode root) {
        return dp(root);
    }
    public int dp(TreeNode root){
        if(root==null)
            return 0;
        
        if(memo.containsKey(root))
            return memo.get(root);
        
        int take = root.val;
        if(root.left!=null)
            take+=dp(root.left.left) + dp(root.left.right);
        if(root.right!=null)
            take+=dp(root.right.left) + dp(root.right.right);
        
        int skip = dp(root.left) + dp(root.right);
        memo.put(root, Math.max(take,skip));
        
        return memo.get(root);
    }
}