class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;
        
        int low = 0, high = nums.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(mid == 0){
                if(nums[mid] > nums[mid+1])
                    return mid;
                else
                    low = mid + 1;
            }
            else if(mid == nums.length-1){
                if(nums[mid] > nums[mid-1])
                    return mid;
                else
                    high = low - 1;
            }
            else if(nums[mid] > nums[mid+1]){
                if(nums[mid] > nums[mid-1])
                    return mid;
                else
                    high = mid - 1;
            }
            else
                low = mid + 1;
        }
        
        return low;
    }
}