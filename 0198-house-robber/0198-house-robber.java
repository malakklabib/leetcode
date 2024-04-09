class Solution {
    int[] memo;
    int[] nums;
    public int rob(int[] nums) {
        this.nums = nums;
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return dp(0);
    }
    public int dp(int i){
        if(i >= nums.length)
            return 0;
        if(memo[i]!=-1)
            return memo[i];
        memo[i] = Math.max(nums[i]+dp(i+2), dp(i+1));
        return memo[i];
    }
}