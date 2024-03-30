class Solution {
    Set<Integer> rest = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    boolean[] seen;
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        for(int i: restricted)
            rest.add(i);
        for(int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());
        for(int[] edge: edges) {
            int n1 = edge[0];
            int n2 = edge[1];
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }
        seen = new boolean[n];
        int ans = 1;
        for(int neighbor: graph.get(0)){
            if(!seen[neighbor] && !rest.contains(neighbor)){
                seen[neighbor] = true;
                int dfsRes = 1+dfs(neighbor);
                ans = Math.max(ans, dfsRes);
            }
        }
        return ans;
    }
    public int dfs(int node) {
        int ans = 0;
        for(int neighbor: graph.get(node)) {
            if(!seen[neighbor] && !rest.contains(neighbor)){
                seen[neighbor] = true;
                ans+= 1+dfs(neighbor);
            }
        }
        return ans;
    }
}