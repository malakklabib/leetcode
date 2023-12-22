class Solution {
    int[] prices;
    int[][] memo;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++)
            Arrays.fill(memo[i], -1);
        return dp(0, 0);
    }
    public int dp(int i, int holding){
        if(i==prices.length)
            return 0;
        if(memo[i][holding]!=-1)
            return memo[i][holding];
        memo[i][holding] = dp(i+1, holding);
        if(holding==0)
            memo[i][0] = Math.max(memo[i][holding], -prices[i] + dp(i+1, 1));
        else
            memo[i][1] = Math.max(memo[i][holding], prices[i] + dp(i+1, 0));
        return memo[i][holding];
    }
}