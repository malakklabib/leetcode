/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;           5
 *         this.left = left;            14
 *         this.right = right;       10    77
 *     }                                      95
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            root = new TreeNode(val, null, null);
            return root;
        }
        insert(root, val);
        return root;
    }
    public void insert(TreeNode node, int val) {
        if(node==null)
            return;
        if(node.left==null && node.val > val){
            TreeNode newNode = new TreeNode(val, null, null);
            node.left = newNode;
        }
        else if(node.right==null && node.val < val){
            TreeNode newNode = new TreeNode(val, null, null);
            node.right = newNode;
            return;
        }
        else if(node.val > val)
            insert(node.left, val);
        else
            insert(node.right, val);
    }
}