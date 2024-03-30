class Solution {
    int ans;
    Map<Integer, List<Integer>> g = new HashMap<>();
    Set<String> roads = new HashSet<>();
    boolean[] seen;
    public int minReorder(int n, int[][] connections) {
        for(int i = 0; i < n-1; i++) {
            int c1 = connections[i][0];            
            int c2 = connections[i][1];
            if(!g.containsKey(c1))
                g.put(c1, new ArrayList<>());
            if(!g.containsKey(c2))
                g.put(c2, new ArrayList<>());
            g.get(c1).add(c2);            
            g.get(c2).add(c1);
            roads.add(c1+","+c2);
        }
        seen = new boolean[n];
        seen[0] = true;
        return dfs(0);
    }
    public int dfs(int node) {
        int ans = 0;
        for(int neighbor: g.get(node)){
            if(!seen[neighbor]){
                seen[neighbor] = true;
                String road = node+","+neighbor;
                if(roads.contains(road))
                    ans++;
                ans+= dfs(neighbor);
            }
        }
        return ans;
    }
}