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
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Set<TreeNode> seen = new HashSet<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dfs(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        seen.add(target);
        int ans = 0;
        while(ans!=k && !queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.remove();
                for (TreeNode neighbor: new TreeNode[]{node.left, node.right, parent.get(node)}) {
                    if (neighbor != null && !seen.contains(neighbor)) {
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            ans++;
        }
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty())
            res.add(queue.remove().val);
        return res;
    }
    public void dfs(TreeNode node){
        if(node==null)
            return;
        if(node.right!=null){
            parent.put(node.right, node);
            dfs(node.right);
        }
        if(node.left!=null) {
            parent.put(node.left, node);
            dfs(node.left);
        }
    }
}