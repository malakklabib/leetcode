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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> toDelete = new HashSet<>();
        
        for(int node: to_delete)
            toDelete.add(node);
        
        root = delete(root, toDelete, res);
        
        if(root!=null)
            res.add(root);
        
        return res;
    }
    
    private TreeNode delete(TreeNode root, Set<Integer> del, List<TreeNode> res){
        if(root == null)
            return null;
        
        root.left = delete(root.left, del, res);
        root.right = delete(root.right, del, res);
        
        if(del.contains(root.val)){
            if(root.left!=null)
                res.add(root.left);
            if(root.right!=null)
                res.add(root.right);
            
            return null;
        }
        
        return root;
    }
}