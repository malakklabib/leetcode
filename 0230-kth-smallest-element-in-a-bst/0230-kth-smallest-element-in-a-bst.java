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
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        for(int i : list){
            k--;
            if(k==0)
                return i;
        }
        return -1;
        
    }
    public void helper(TreeNode node){
        if(node==null)
            return;
        
        helper(node.left);
        list.add(node.val);
        helper(node.right);
        
    }
}