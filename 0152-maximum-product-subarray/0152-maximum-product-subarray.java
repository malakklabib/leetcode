class Solution {
    int[] nums;
    long[] memo;
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int min = 1, max = 1;
        
        int res = Integer.MIN_VALUE;
        for(int num: nums)
            res = Math.max(res,num);
        
        for(int i = n-1; i >= 0; i--) {
            if(nums[i] == 0){
                max = 1;
                min = 1;
            }
            else{
                int tmp1 = min*nums[i];
                int tmp2 = max*nums[i];
                min = Math.min(nums[i], Math.min(tmp1,tmp2));
                max = Math.max(nums[i], Math.max(tmp1,tmp2));
                res = Math.max(res, max);
            }
        }
        
        return res;
    }
}