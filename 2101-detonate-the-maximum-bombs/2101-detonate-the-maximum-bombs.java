class Solution {
    boolean[] seen;
    Map<Integer, List<Integer>> g = new HashMap<>();
    public int maximumDetonation(int[][] bombs) {
        seen = new boolean[bombs.length];
        for(int i = 0; i < bombs.length; i++) {
            int x = bombs[i][0], y = bombs[i][1], r = bombs[i][2];
            for(int j = 0; j < bombs.length; j++) {
                if(!g.containsKey(j))
                    g.put(j, new ArrayList<>());
                if(j==i)
                    continue;
                int newx = bombs[j][0], newy = bombs[j][1];
                if(withinBounds(x,newx,y,newy,r))
                    g.get(i).add(j);
            }
        }
        int res = 1;
        for(int i = 0; i < bombs.length; i++){
            seen[i] = true;
            res = Math.max(res, dfs(i));
            seen = new boolean[bombs.length];
        }
        return res;
    }
    public int dfs(int node) {
        int ans = 1;
        for(int neighbor: g.get(node)) {
            if(!seen[neighbor]) {
                seen[neighbor] = true;
                ans+= dfs(neighbor);
            }
        }
        return ans;
    }
    public boolean withinBounds(int cx,int nx,int cy,int ny,int cr) {
        double dist = Math.sqrt(Math.pow(cx-nx,2) + Math.pow(cy-ny,2));
        return dist <= cr;
    }
}