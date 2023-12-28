class Solution {
    public int jump(int[] nums) {
        int noOfJumps = 0;
        for(int i = 0; i < nums.length-1;) {
            int range = nums[i];
            int jumpIndex = 0, nextJump = 0;
            for(int j = i+1; j <= range+i; j++) {
                if(j == nums.length-1){
                    jumpIndex = nums.length-1;
                    break;
                }
                if(j+nums[j] >= nextJump){
                    jumpIndex = j;
                    nextJump = j+nums[j];
                }
            }
            i = Math.min(jumpIndex, nums.length-1);
            noOfJumps++;
        }
        return noOfJumps;
    }
}