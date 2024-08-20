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
            int tmp = nums[pivot];
            nums[pivot] = nums[minInd];
            nums[minInd] = tmp;
        }
        nums = reverse(nums, pivot+1, n-1);
    }
    
    public int[] reverse(int[] nums, int s, int e){
        while(s <= e){
            System.out.println(s + " " + e);
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
            s++;
            e--;
        }
        return nums;
    }
}