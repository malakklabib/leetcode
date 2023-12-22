class Solution {
    int[] nums;
    int[][] memo;
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        this.nums = nums;
        memo = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++)
            Arrays.fill(memo[i], -1);
        return Math.max(dp(nums.length-1, 1), dp(nums.length-2, 0));
    }
    public int dp(int i, int last) {
        if(i==0) {
            if(last==1) return 0;
            else return nums[i];
        }
        if(i < 0) return 0;
        if(memo[i][last] != -1)
            return memo[i][last];
        memo[i][last] = Math.max(nums[i] + dp(i-2, last), dp(i-1, last));
        return memo[i][last];
    }
}