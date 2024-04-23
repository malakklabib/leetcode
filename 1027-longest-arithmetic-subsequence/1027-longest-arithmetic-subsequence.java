public class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();  // Key is the difference, value is a map (key is the index, value is length of sequence ending at that index)
        int ans = 2;  // The minimum length of any arithmetic sequence is 2

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int diff = nums[j] - nums[i];
                if (!dp.containsKey(diff)) {
                    dp.put(diff, new HashMap<>());
                }
                Map<Integer, Integer> map = dp.get(diff);
                int len1 = map.getOrDefault(i, 1);  // Get the length ending at i, default is 1 if not present
                int len2 = map.getOrDefault(j, 1);  // Get the length ending at j, default is 1 if not present
                int currentLength = Math.max(len1 + 1, len2);  // Length of sequence ending at j is either extended from i or as it was
                map.put(j, currentLength);
                ans = Math.max(ans, currentLength);  // Update the answer
            }
        }
        
        return ans;
    }
}
