class Solution {
    int[][] memo;
    int[] prices;
    int fee;
    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
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
        int ans = dp(i+1, holding);
        if(holding==0)
            ans = Math.max(ans, -prices[i] + dp(i+1, 1));
        else
            ans = Math.max(ans, prices[i] - fee + dp(i+1, 0));
        memo[i][holding] = ans;
        return memo[i][holding];
    }
}