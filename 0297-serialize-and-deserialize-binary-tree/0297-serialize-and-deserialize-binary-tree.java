/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "#";
        
        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(" ")));
        return helper(q);
    }
    
    public TreeNode helper(Queue<String> q) {
        String node = q.poll();
        
        if(node.equals("#"))
            return null;
        
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = helper(q);
        root.right = helper(q);
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));