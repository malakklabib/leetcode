class Solution {
    public int[] getAverages(int[] nums, int k) {
        int start = k;
        int end = nums.length-k;
        int[] avgs = new int[nums.length];
        
        int s = 0, e = 2*k;
        long sum = 0;
        long[] a = new long[nums.length];
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            if(i==e){
                a[i-k] = sum;
                sum-=nums[s];
                s++;
                e++;
            }
        }
        
        if(k > nums.length){
            start = 0;
            end = 0;
        }
        for(int i = 0; i < start; i++)
            avgs[i] = -1;
        for(int i = end; i < nums.length; i++)
            avgs[i] = -1;
        
        for(int i = start; i < end; i++)
            avgs[i] = (int)(a[i]/(long)(2*k + 1));
        return avgs;
    }
}