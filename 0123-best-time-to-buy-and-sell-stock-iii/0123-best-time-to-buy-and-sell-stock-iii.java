class Solution {
    Integer[][][] memo;
    int n;
    int[] prices;
    public int maxProfit(int[] prices) {
        n = prices.length;
        memo = new Integer[n][2][3];
        this.prices = prices;
        return dp(0,0,2);
    }
    
    public int dp(int i, int isHaving, int transactions){
        if(i == n || transactions==0)
            return 0;
        
        if(memo[i][isHaving][transactions]!=null)
            return memo[i][isHaving][transactions];
        
        int skip = dp(i+1, isHaving, transactions);
        if(isHaving==0){
            int buy = -prices[i] + dp(i+1, 1, transactions);
            memo[i][isHaving][transactions] = Math.max(buy,skip);
        }
        else{
            int sell = prices[i] + dp(i+1, 0, transactions-1);
            memo[i][isHaving][transactions] = Math.max(sell,skip);
        }
        
        return memo[i][isHaving][transactions];
    }
}