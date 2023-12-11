class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0]==1)
            return 0;
        dp[0][0] = 1;
        for(int i=0; i < obstacleGrid.length; i++){
            for(int j = 0; j < obstacleGrid[i].length; j++){
                if(obstacleGrid[i][j]==0){
                    if(i > 0)
                        dp[i][j] += dp[i-1][j];
                    if(j > 0)
                        dp[i][j] += dp[i][j-1];
                }
                     
                System.out.println(dp[i][j]);
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}