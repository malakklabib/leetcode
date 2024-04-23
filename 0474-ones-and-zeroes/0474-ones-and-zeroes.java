class Solution {
    Integer[][][] memo;
    String[] strs;
    int m,n;
    public int findMaxForm(String[] strs, int m, int n) {
        memo = new Integer[strs.length][m+1][n+1];
        this.strs = strs;
        return dp(0, m, n);
    }
    public int dp(int i, int m, int n){
        if(m < 0 || n < 0)
            return -1;
        
        if(i==strs.length || (m==0 && n==0))
            return 0;
        
        if(memo[i][m][n]!=null)
            return memo[i][m][n];
        
        String s = strs[i];
        int countZ = 0;
        int countO = 0;
        for(int j = 0; j < s.length(); j++){
            if(s.charAt(j)=='0')
                countZ++;
            if(s.charAt(j)=='1')
                countO++;
        }
        int skip = dp(i+1, m, n);
        int take = 1 + dp(i+1, m-countZ, n-countO);
        return memo[i][m][n] = Math.max(skip, take);
    }
}