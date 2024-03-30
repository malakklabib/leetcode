class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();
    boolean[] seen;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        for(int i = 0; i < n; i++)
            g.put(i, new ArrayList<>());
        for(int[] edge : edges){
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        seen = new boolean[n];
        return source==destination || dfs(source, destination);
    }
    public boolean dfs(int s, int d) {
        boolean ans = false;
        for(int node: g.get(s)) {
            if(node==d)
                return true;
            if(!seen[node]){
                seen[node] = true;
                ans |= dfs(node, d);
            }
        }
        return ans;
    }
}