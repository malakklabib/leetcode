class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        
        for(int i = 1; i <= n; i++) {
            for(String w: wordDict){
                int len = w.length();
                if(len <= i && dp[i-len]==true && s.substring(i-len,i).equals(w)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}