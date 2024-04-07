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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        for(int i: preorder)
            pre.add(i);
        for(int i: inorder)
            in.add(i);
        return build(pre,in);
    }
    public TreeNode build(List<Integer> pre, List<Integer> in){
        if(pre.size()==0 || in.size()==0)
            return null;
        
        int rootVal = pre.get(0);
        int indexOfRoot = in.indexOf(rootVal);
        List<Integer> inLeft = new ArrayList<>();
        List<Integer> inRight = new ArrayList<>();
        
        for(int i = 0; i < in.size(); i++) {
            if(i < indexOfRoot)
                inLeft.add(in.get(i));
            else if(i > indexOfRoot)
                inRight.add(in.get(i));
        }
        
        pre.remove(0);
        TreeNode left = build(pre, inLeft);
        TreeNode right = build(pre, inRight);
        return new TreeNode(rootVal, left, right);
    }
}