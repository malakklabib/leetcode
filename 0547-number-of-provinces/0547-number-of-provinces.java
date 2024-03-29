class Solution {
    Map<Integer, List<Integer>> g = new HashMap<>();
    boolean[] seen;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        g.put(0, new ArrayList<>());
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                if(!g.containsKey(j)) 
                    g.put(j, new ArrayList<>());
                if(isConnected[i][j]==1){
                    g.get(i).add(j);
                    g.get(j).add(i);
                }
            }
        }
        seen = new boolean[n];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(!seen[i]){
                ans++;
                seen[i] = true;
                dfs(g.get(i));
            }
        }
        return ans;
    }
    public void dfs(List<Integer> neighbors) {
        for(int neighbor: neighbors) {
            if(!seen[neighbor]) {
                seen[neighbor] = true;
                dfs(g.get(neighbor));
            }
        }
    }
}