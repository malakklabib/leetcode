class Solution {
    int[] memo;
    public int integerBreak(int n) {
        if(n==2) return 1;
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        
        for(int i = n-1; i > 0; i--)
            memo[n] = Math.max(memo[n], i * dp(n-i));
        return memo[n];
    }
    public int dp(int i) {
        if(i==0)
            return 1;
        if(memo[i] != -1)
            return memo[i];
        for(int j = i; j > 0; j--)
            memo[i] = Math.max(memo[i], j * dp(i-j));
        return memo[i];
    }
}