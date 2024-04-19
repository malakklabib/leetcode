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
    int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        
        dfs(root, targetSum, 0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return ans;
    }
    public void dfs(TreeNode root, int sum, long currSum){
        if(root==null)
            return;
        
        currSum+= root.val;
        if(currSum == sum)
            ans++;
        
        dfs(root.left,sum,currSum);
        dfs(root.right,sum,currSum);
    }
}