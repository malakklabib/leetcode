class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length+1;
        Set<Integer> numSet = new HashSet<Integer>();
        for(int i = 0; i < n-1; i++)
            numSet.add(nums[i]);
        for(int i = 0; i < n; i++){
            if(!numSet.contains(i))
                return i;
        }
        return -1;
    }
}