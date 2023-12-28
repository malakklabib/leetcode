class Solution {
    public int longestArithSeqLength(int[] nums) {        
        int maxLength = 2;
        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = i-1; j >= 0; j--) {
                int d = nums[i] - nums[j];
                dp[i].put(d, Math.max(dp[i].getOrDefault(d, -1) ,dp[j].getOrDefault(d, 1) + 1));
                maxLength = Math.max(maxLength, dp[i].get(d));
            }
        }
        
        return maxLength;
    }
}