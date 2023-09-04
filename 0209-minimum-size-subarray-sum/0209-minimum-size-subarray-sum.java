class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = 0;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            len++;
            while(sum >= target){
                ans = Math.min(ans, len);
                sum-=nums[i-len+1];
                len--;
            }
        }
        if(ans == Integer.MAX_VALUE)
            return 0;
        return ans;
            
    }
}