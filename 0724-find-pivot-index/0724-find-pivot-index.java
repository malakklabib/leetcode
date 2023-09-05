class Solution {
    public int pivotIndex(int[] nums) {
        int[] p = new int[nums.length+1];
        p[0] = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            p[i+1] = sum;
        }
        for(int i = 0; i < nums.length; i++){
            if(p[p.length-1] - p[i+1] == p[i])
                return i;
        }
        return -1;
    }
    // 1 7 3  6  5  6
    // 0 1 8 11 17 22 28
}