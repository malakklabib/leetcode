class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for(int i=0;i<nums.length;i++){
            l = Math.max(l, nums[i]);
            r += nums[i];
        }
        int min = Integer.MAX_VALUE;
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(check(nums, k, mid)){
                min = Math.min(min, mid);
                r = mid - 1;
            }
            else
                l = mid + 1;
        }
        return l;
    }
    
    // public boolean check(int[] nums, int k, int p) {
    //     int partitionCount = 0, sum = 0;
    //     for(int n: nums) {
    //         if(sum+n <= p)
    //             sum+= n;
    //         else{
    //             sum = 0;
    //             partitionCount++;
    //         }
    //     }
    //     return partitionCount <= k;
    // }
    
    private boolean check(int[] nums, int m, int mid){
        int chunks = 0, i=0;
        while(i < nums.length){
            int val = 0;
            while(i < nums.length && nums[i] + val <= mid) val += nums[i++];
            chunks++;
        }
        return chunks <= m;
    }

}