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
 *         this.right = right; 1
 *     }                      2 3  
 * }                         4   5
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root==null) return ans;
        int depth = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> levelNodes = new ArrayDeque<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(depth%2==0)
                    levelNodes.add(node.val);
                else
                    levelNodes.addFirst(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            List<Integer> list = new ArrayList<>();
            for(int i: levelNodes)
                list.add(i);
            ans.add(list);
            depth++;
        }
        return ans;
    }
}