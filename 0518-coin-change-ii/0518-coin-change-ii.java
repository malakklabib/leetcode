class Solution {
    int[][] memo;
    int[] coins;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        memo = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length; i++)
            Arrays.fill(memo[i], -1);
        return dp(amount, 0);
    }
    public int dp(int amount, int i) {
        if(amount < 0 || i==coins.length) return 0;
        if(amount==0) return 1;
        if(memo[i][amount] != -1) return memo[i][amount];
        
        int take = dp(amount-coins[i], i);
        int skip = dp(amount, i+1);
        
        return memo[i][amount] = take + skip;
    }
}