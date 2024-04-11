class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(k >= n)
            k %= n;
        if(k==0)
            return;
        
        int[] arr = new int[n];
        int p1 = n-k, p2 = 0;
        while(p2 < n) {
            if(p1==n)
                p1 = 0;
            arr[p2] = nums[p1];
            p2++;
            p1++;
        }
        
        for(int i = 0; i < n; i++)
            nums[i] = arr[i];
    }
}