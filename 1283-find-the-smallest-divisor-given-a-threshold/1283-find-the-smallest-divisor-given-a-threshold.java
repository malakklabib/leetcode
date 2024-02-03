class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1, r = 0;
        for(int i: nums)
            r = Math.max(i, r);
        while(l<=r) {
            int mid = l + (r-l)/2;
            if(check(nums,threshold,mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
    public boolean check(int[] nums, int thres, int div) {
        int sum = 0;
        for(int i: nums) {
            sum+= Math.ceil((double)i/div);
            if(sum > thres) return false;
        }
        return true;
    }
}