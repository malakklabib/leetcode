class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int[] dp = new int[nums.length];
        int sliceLength = 0;
        int slices = 0;
        
        for(int i = 2; i < nums.length; i++){
            if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
                if(sliceLength>=3)
                    sliceLength++;
                else
                    sliceLength = 3;
                slices+=sliceLength-2;
            }
            else
                sliceLength = 0;
            dp[i] = slices;
        }
        for(int i:dp)
            System.out.print(i + " ");
        
        return dp[nums.length-1];
    }
}