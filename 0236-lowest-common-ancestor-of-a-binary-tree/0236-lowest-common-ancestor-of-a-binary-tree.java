/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode lastParent;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        
        if(containsNode(root, p.val) && containsNode(root,q.val)){
            lastParent = root;
            lowestCommonAncestor(root.left,p,q);
            lowestCommonAncestor(root.right,p,q);
        }
        
        return lastParent;
    }
    public boolean containsNode(TreeNode root, int node){
        if(root==null)
            return false;
        
        if(root.val==node)
            return true;
        
        return containsNode(root.left,node) || containsNode(root.right,node);
    }
}