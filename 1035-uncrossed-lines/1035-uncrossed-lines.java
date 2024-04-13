class Solution {
    Integer[][] memo;
    int[] nums1;
    int[] nums2;
    public int maxUncrossedLines(int[] n1, int[] n2) {
        nums1 = n1;
        nums2 = n2;
        memo = new Integer[n1.length][n2.length];
        return dp(0,0);
    }
    
    public int dp(int i, int j){
        if(i==nums1.length || j==nums2.length)
            return 0;
        
        if(memo[i][j]!=null)
            return memo[i][j];
    
        int take = 0;
        int index = -1;
        for(int k = j; k < nums2.length; k++){
            if(nums1[i]==nums2[k]){
                take = 1;
                index = k;
                break;
            }
        }
        if(index!=-1)
            take += dp(i+1,index+1);
        else
            take += dp(i+1,j);
        int skip = dp(i+1,j);
        
        memo[i][j] = Math.max(skip, take);
        
        return memo[i][j];
    }

}