class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for(int i = 1; i < nums.length; i++) {
            for(int j = i; j >= 0; j--){
                int tmp = 1;
                if(nums[i]>nums[j])
                    tmp = 1 + dp[j];
                dp[i] = Math.max(dp[i],tmp);
            }
        }
        
        int ans = 1;
        for(int num: dp)
            ans = Math.max(num,ans);
        return ans;
    }
}