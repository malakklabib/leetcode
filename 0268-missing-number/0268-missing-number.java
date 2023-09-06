class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length+1;
        Set<Integer> numSet = new HashSet<Integer>();
        for(int i = 0; i < n-1; i++)
            numSet.add(nums[i]);
        int i =0;
        for(int num: numSet){
            if(num!=i)
                return i;
            i++;
        }
        if(i < n)
            return n-1;
        return -1;
    }
}