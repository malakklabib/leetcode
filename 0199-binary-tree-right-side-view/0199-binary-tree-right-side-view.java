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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return list;
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            int prv=0;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();
                prv = node.val;
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null) 
                    queue.add(node.right);
            }
            list.add(prv);
        }
        return list;
    }
}