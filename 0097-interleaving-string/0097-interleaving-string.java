class Solution {
    Boolean[][] memo;
    String s1, s2, s3;
    int m,n,k;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        m = s1.length();
        n = s2.length();
        k = s3.length();
        memo = new Boolean[m][n];
        return dp(0,0);
    }
    
    public boolean dp(int p1, int p2) {
        int p3 = p1 + p2;
        if(p1==m)
            return s2.substring(p2,n).equals(s3.substring(p3,k));

        if(p2==n)
            return s1.substring(p1,m).equals(s3.substring(p3,k));
        
        if(p3==k)
            return memo[p1][p2] = false;
        
        if(memo[p1][p2]!=null)
            return memo[p1][p2];
        
        if(s1.charAt(p1)==s2.charAt(p2) && s1.charAt(p1)==s3.charAt(p3))
            memo[p1][p2] = dp(p1+1, p2) || dp(p1, p2+1);
        
        else if(s1.charAt(p1)==s3.charAt(p3))
            memo[p1][p2] = dp(p1+1,p2);
        
        else if(s2.charAt(p2)==s3.charAt(p3))
            memo[p1][p2] = dp(p1,p2+1);
        
        else
            return false;
        
        return memo[p1][p2];
    }
}