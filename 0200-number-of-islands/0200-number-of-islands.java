class Solution {
    int n, m;
    boolean[][] seen;
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        seen = new boolean[n][m];
        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j]=='1' && !seen[i][j]) {
                    seen[i][j] = true;
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }
    public boolean valid(int row, int col) {
        return 0 <= row && row < n && 0 <= col && col < m;
    }
    public void dfs(int row, int col, char[][] grid) {
        for(int[] direction: directions) {
            int newRow = row+direction[0];
            int newCol = col+direction[1];
            if(valid(newRow, newCol) && !seen[newRow][newCol] && grid[newRow][newCol]=='1'){
                seen[newRow][newCol] = true;
                dfs(newRow,newCol,grid);
            }
        }
    }
}