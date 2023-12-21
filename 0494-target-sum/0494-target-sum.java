class Solution {
    int[] nums;
    int target;
    int[][] memo;
    int maxSum;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        maxSum = 0;
        for(int i: nums)
            maxSum+=i;
        memo = new int[nums.length][2*maxSum+1];
        for(int i = 0; i < nums.length; i++)
            Arrays.fill(memo[i], -1);
        return dp(nums.length-1, 0);
    }
    public int dp(int i, int sum){
        if(i==-1){
            if(sum==target) return 1;
            else return 0;
        }
        if(memo[i][sum+maxSum]!=-1)
            return memo[i][sum+maxSum];
        memo[i][sum+maxSum] = dp(i-1, sum+nums[i]) + dp(i-1, sum-nums[i]);
        return memo[i][sum+maxSum];
    }
}