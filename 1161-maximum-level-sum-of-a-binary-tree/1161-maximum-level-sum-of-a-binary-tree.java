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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int maxSum = root.val;
        int maxH = 1;
        int h = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            int currSum = Integer.MIN_VALUE;    
            for(int i = 0; i < size; i++){
                TreeNode node = q.remove();
                
                if(currSum == Integer.MIN_VALUE)
                    currSum = 0;
                currSum+=node.val;
                
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            h++;
            if(currSum > maxSum){
                maxSum = currSum;
                maxH = h;
            }
        }
        return maxH;
    }
}