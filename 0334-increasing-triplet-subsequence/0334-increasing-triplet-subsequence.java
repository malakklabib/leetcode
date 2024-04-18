class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if(n < 3)
            return false;
        
        int first = nums[0];
        int second = Integer.MAX_VALUE;

        for(int third : nums){
            if(third > second)
                return true;
                
            else if(third > first)
                second = third;
            
            else
                first = third;
        }
        return false;
    }
}