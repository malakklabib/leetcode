class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++)
            numSet.add(nums[i]);
        for(int i = 0; i < nums.length+1; i++){
            if(!numSet.contains(i))
                return i;
        }
        return -1;
    }
}