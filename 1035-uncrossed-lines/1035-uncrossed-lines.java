class Solution {
    public int maxUncrossedLines(int[] n1, int[] n2) {
        int[][] dp = new int[n1.length+1][n2.length+1];
        dp[n1.length][n2.length] = 0;
        int connect = 0, skip1 = 0, skip2 = 0;
        for(int i = n1.length-1; i >= 0; i--) {
            for(int j = n2.length-1; j >= 0; j--) {
                if(n1[i] == n2[j])
                    dp[i][j] = 1 + dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}