class Solution {
    String smallest = "";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,"");
        return smallest;
    }
    public void dfs(TreeNode root, String s){
        if(root==null)
            return;
        
        s = (char)(root.val+'a') + s;
        
        if(root.left==null && root.right==null){
            if(smallest.isEmpty() || smallest.compareTo(s) > 0)
                smallest = s;
        }
        
        dfs(root.left, s);
        dfs(root.right, s);
    }
}
