class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] p = new int[nums.length+1];
        for(int i= 0; i < nums.length; i++)
            p[i+1] = p[i] + nums[i];
        Map<Integer, Integer> count = new HashMap();
        int ans = 0;
        for (int x: p) {
            ans += count.getOrDefault(x, 0);
            count.put(x+goal, count.getOrDefault(x+goal, 0) + 1);
        }

        return ans;
    }
}