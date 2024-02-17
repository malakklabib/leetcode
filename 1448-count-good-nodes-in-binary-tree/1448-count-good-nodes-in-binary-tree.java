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
    public int goodNodes(TreeNode root) {
        return 1 + goodNodesH(root, root);
    }
    public int goodNodesH(TreeNode root, TreeNode lastLargerNode) {
        if(root==null)
            return 0;
        int countLeft = 0, countRight = 0;
        TreeNode lastLargerNodeLeft = lastLargerNode, lastLargerNodeRight = lastLargerNode;
        if(root.left!=null && root.left.val>=lastLargerNode.val){
            countLeft++;
            lastLargerNodeLeft = root.left;
        }
        if(root.right!=null && root.right.val>=lastLargerNode.val){
            countRight++;
            lastLargerNodeRight = root.right;
        }
        return countLeft + countRight + goodNodesH(root.left, lastLargerNodeLeft) + goodNodesH(root.right, lastLargerNodeRight);
    }
}