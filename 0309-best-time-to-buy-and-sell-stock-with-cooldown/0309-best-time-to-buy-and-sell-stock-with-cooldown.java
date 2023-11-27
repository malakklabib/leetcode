class Solution {
    int[] prices;
    int[][][] memo;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new int[prices.length][2][2];
        for(int i = 0; i < prices.length; i++)
            for(int j = 0; j < 2; j++)
                Arrays.fill(memo[i][j],-1);
        return dp(0, 0, 0);
    }
    public int dp(int i, int holding, int cool){
        if(i==prices.length)
            return 0;
        if(memo[i][holding][cool]!=-1)
            return memo[i][holding][cool];
        int ans = 0;
        if(cool==1)
            ans = dp(i+1, holding, 0);
        else{
            if(holding==0)
                ans = Math.max(-prices[i] + dp(i+1, 1, 0), dp(i+1, 0, 0));
            else
                ans = Math.max(prices[i] + dp(i+1, 0, 1), dp(i+1, 1, 0));
        }
        memo[i][holding][cool] = ans;
        return memo[i][holding][cool];
    }
}