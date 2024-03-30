class Solution {
    boolean[] seen;
    Map<Integer, List<Integer>> g = new HashMap<>(); 
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        for(int i = 0; i < n; i++)
            g.put(i, rooms.get(i));
        seen = new boolean[n];
        seen[0] = true;
        return dfs(0)+1==n;
    }
    public int dfs(int node) {
        int ans = 0;
        for(int neighbor: g.get(node)) {
            if(!seen[neighbor]) {
                seen[neighbor] = true;
                ans++;
                ans+=dfs(neighbor);
            }
        }
        return ans;
    }
}