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
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return bst(0,nums.length-1);
    }
    public TreeNode bst(int i, int j){
        if(j<i)
            return null;
        
        int cent = (i+j)/2;
        
        TreeNode root = new TreeNode(nums[cent]);
        root.left = bst(i, cent-1);
        root.right = bst(cent+1,j);
        
        return root;
    }
}