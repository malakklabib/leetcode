class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int[] res = new int[2];
        Arrays.fill(res,-1);
        
        while(l <= r){
            int m = (r-l)/2 + l;
            if(nums[m] == target){
                if(m > 0 && nums[m-1] < target || m==0){
                    res[0] = m;
                    break;
                }
                else
                    r = m -1;
            }
            else if(nums[m] > target)
                r = m - 1;
            else
                l = m + 1;
        }
        
        l = 0; 
        r = nums.length-1;
        while(l <= r){
            int m = (r-l)/2 + l;
            if(nums[m] == target){
                if(m < nums.length-1 && nums[m+1] > target || m==nums.length-1){
                    res[1] = m;
                    break;
                }
                else
                    l = m + 1;
            }
            else if(nums[m] > target)
                r = m - 1;
            else
                l = m + 1;
        }
        
        return res;
    }
}