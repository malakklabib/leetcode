class Solution {
    public int islandPerimeter(int[][] grid) {
        int per = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]==1){
                    if(i==0 || grid[i-1][j]==0)
                        per++;
                    if(i==n-1 || grid[i+1][j]==0)
                        per++;
                    if(j==0 || grid[i][j-1]==0)
                        per++;
                    if(j==m-1 || grid[i][j+1]==0)
                        per++;
                }
            }
        }
        return per;
    }
}