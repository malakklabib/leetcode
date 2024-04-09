class Solution {
    int m, n;
    List<List<Integer>> res;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    int[][] heights;
    boolean[][] pacific, atlantic;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        
        this.heights = heights;
        pacific = new boolean[m][n];
        atlantic = new boolean[m][n];
        res = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
            dfs(i, n-1, atlantic);
        }
        for(int j = 0; j < n; j++) {
            dfs(0, j, pacific);
            dfs(m-1, j, atlantic);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        
        return res;
    }
    
    public void dfs(int r, int c, boolean[][] seen) {
        seen[r][c] = true;
        for(int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(valid(nr,nc,r,c) && !seen[nr][nc])
                dfs(nr, nc, seen);
        }
    }
    
    public boolean valid(int nr, int nc, int r, int c){
        return 0 <= nr && nr < m && 0 <= nc && nc < n && heights[nr][nc] >= heights[r][c];
    }
}
