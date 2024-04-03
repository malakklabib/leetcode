class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        int prod = 1;
        for(int i = 0; i < n; i++){
            prod*=nums[i];
            pre[i] = prod;
        }
        prod = 1;
        for(int i = n-1; i>=0; i--){
            prod*=nums[i];
            post[i] = prod;
        }
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            prod = 1;
            if(i>0)
                prod*=pre[i-1];
            if(i<n-1)
                prod*=post[i+1];
            res[i] = prod;
        }
        return res;
    }
}