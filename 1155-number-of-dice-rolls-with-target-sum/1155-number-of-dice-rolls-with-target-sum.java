class Solution {
    Integer memo[][];
    int n, k;
    public int numRollsToTarget(int n, int k, int target) {
        this.n = n;
        this.k = k;
        memo = new Integer[n][target+1];
        return dp(0, target);
    }
    public int dp(int i, int curr){
        if(i==n && curr==0)
            return 1;
        if(i==n || curr<=0)
            return 0;
        
        if(memo[i][curr]!=null)
            return memo[i][curr];
        
        int ans = 0;
        for(int j = 1; j <= k; j++){
            ans += dp(i+1, curr-j);
            ans %= 1000000007;
        }
        
        return memo[i][curr] = ans;
    }
}