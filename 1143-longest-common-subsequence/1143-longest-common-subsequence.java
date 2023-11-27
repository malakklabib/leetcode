class Solution {
    int[][] memo;
    String s1;
    String s2;
    public int longestCommonSubsequence(String text1, String text2) {
        s1 = text1;
        s2 = text2;
        memo = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i < s1.length(); i++)
            Arrays.fill(memo[i], -1);
        return dp(0, 0);
    }
    public int dp(int i, int j){
        if(i==s1.length() || j==s2.length())
            return 0;
        if(memo[i][j]!=-1)
            return memo[i][j];
        if(s1.charAt(i)==s2.charAt(j))
            memo[i][j]=1+dp(i+1,j+1);
        else
            memo[i][j] = Math.max(dp(i,j+1),dp(i+1,j));
        return memo[i][j];
    }
}