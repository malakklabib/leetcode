class Solution {
    public boolean canJump(int[] nums) {
        int noOfHops = 1;
		for(int i=nums.length-2; i>=0; i--){
			if(nums[i]>=noOfHops)
				noOfHops=1;
			else
				noOfHops++;
		}
		return noOfHops==1;
    }
}