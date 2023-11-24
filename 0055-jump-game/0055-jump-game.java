class Solution {
    public boolean canJump(int[] nums) {
        return dac(nums, nums.length-2, 1)==1;
	}

	public static int dac(int[] fuel, int last, int hops){
		if(last<0)
			return hops;
		if(fuel[last]>=hops)
			return dac(fuel, --last, 1);
		else
			return dac(fuel, --last, ++hops);
	}
}