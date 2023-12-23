class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        // dp[i] = 1 + dp[j] for j < i and j>=0 if arr[i] - arr[i-1] = diff
        // dp[i] = dp[i-1] else
        Map<Integer, Integer> dp = new HashMap<>();
        int max = 1;
        for(int num : arr) {
            int maxSeq = dp.getOrDefault(num-difference, 0) + 1;
            dp.put(num, maxSeq);
            max = Math.max(max, maxSeq);
        }
        return max;
    }
}