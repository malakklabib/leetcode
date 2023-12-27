class Solution {
    public int longestArithSeqLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        
        int maxLength = 2;
        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int d = nums[i] - nums[j];
                dp[i].put(d, dp[j].getOrDefault(d, 1) + 1);
                maxLength = Math.max(maxLength, dp[i].get(d));
            }
        }
        
        return maxLength;
    }
}