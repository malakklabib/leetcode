class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length < 3)
            return nums[0];
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if((mid-low)%2==0) {
                if(mid > 0 && nums[mid]==nums[mid-1])
                    high = mid-2;
                else if(mid < nums.length-1 && nums[mid]==nums[mid+1])
                    low = mid+2;
                else
                    return nums[mid];
            }
            else {
                if(mid < nums.length-1 && nums[mid]==nums[mid+1])
                    high = mid-1;
                else if(mid > 0 && nums[mid]==nums[mid-1])
                    low = mid+1;
                else
                    return nums[mid];
            }            
        }
        return -1;
    }
}