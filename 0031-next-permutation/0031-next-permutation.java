class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        if(n==1)
            return;
        
        int pivot = n-2;
        while(pivot >= 0 && nums[pivot] >= nums[pivot+1]){
            pivot--;
        }
        if (pivot >= 0) {
            int minInd = n - 1;
            while (nums[minInd] <= nums[pivot]) {
                minInd--;
            }
            swap(nums, pivot, minInd);
        }
        reverse(nums, pivot+1, n-1);
    }
    
    public void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    public void reverse(int[] nums, int s, int e){
        while(s <= e){
            swap(nums, s, e);
            s++;
            e--;
        }
    }
}