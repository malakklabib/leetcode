class Solution {
    int[][][] memo;
    int[] prices;
    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        memo = new int[prices.length][2][k+1];
        for(int i = 0; i < prices.length; i++)
            for(int j = 0; j < 2; j++)
                Arrays.fill(memo[i][j], -1);
        return dp(0, 0, k);
    }
    public int dp(int i, int holding, int remain){
        
        if(i==prices.length || remain==0)
            return 0;
        
        if(memo[i][holding][remain]!=-1)
            return memo[i][holding][remain];
        
        int ans = 0;
        if(holding==1)
            ans = prices[i] + dp(i+1, 0, remain-1);
        else
            ans = -prices[i] + dp(i+1, 1, remain);
        
        memo[i][holding][remain] = Math.max(ans, dp(i+1, holding, remain));
        
        return memo[i][holding][remain];
    }
}