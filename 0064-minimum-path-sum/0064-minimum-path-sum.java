class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = grid[m-1][n-1];
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                int num = grid[i][j];
                if(i==m-1 && j==n-1)
                    continue;
                else if(i==m-1)
                    dp[i][j] = num + dp[i][j+1];
                else if(j==n-1)
                    dp[i][j] = num + dp[i+1][j];
                else
                    dp[i][j] = num + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
    
        return dp[0][0];
    }
}