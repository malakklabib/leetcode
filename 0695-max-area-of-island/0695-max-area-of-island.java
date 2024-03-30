class Solution {
    Set<String> seen;
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int n, m;
    public int maxAreaOfIsland(int[][] grid) {
        seen = new HashSet<>();
        int ans = Integer.MIN_VALUE;
        n = grid.length;
        m = grid[0].length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j]==1 && !seen.contains(i+","+j)){
                    seen.add(i+","+j);
                    int dfsRes = 1 + dfs(i, j, grid);
                    ans = Math.max(ans, dfsRes);
                }      
            }
        }
        return ans==Integer.MIN_VALUE? 0 : ans;
    }
    public boolean valid(int row, int col, int[][] grid) {
        return 0 <= row && row < n && 0 <= col && col < m && grid[row][col]==1;
    }
    public int dfs(int row, int col, int[][] grid) {
        int ans = 0;
        for(int[] dir: directions) {
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            if(valid(newRow,newCol,grid) && !seen.contains(newRow+","+newCol)){
                seen.add(newRow+","+newCol);
                ans+=1+dfs(newRow,newCol,grid);
            }
        }
        return ans;
    }
}