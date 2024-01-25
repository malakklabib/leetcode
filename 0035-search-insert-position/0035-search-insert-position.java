class Solution {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int mid = 0;
        while(low <= high){
            mid = (low + high)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid] < target)
                low = ++mid;
            else
                high = --mid;
        }
        return Math.max(high,low);
    }
}