class Solution {
    Integer[][] memo;
    String word1,word2;
    int m,n;

    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        this.word1 = word1;
        this.word2 = word2;
        memo = new Integer[m][n];
        return dp(0, 0);
    }

    public int dp(int i, int j) {
        if (i == m) 
            return word2.length() - j;
        
        if (j == n) 
            return word1.length() - i;

        if (memo[i][j] != null)
            return memo[i][j];

        if (word1.charAt(i) == word2.charAt(j)) 
            return memo[i][j] = dp(i + 1, j + 1);

        int insert = 1 + dp(i, j + 1);
        int delete = 1 + dp(i + 1, j);
        int replace = 1 + dp(i + 1, j + 1);

        return memo[i][j] = Math.min(Math.min(insert, delete), replace);
    }
}
