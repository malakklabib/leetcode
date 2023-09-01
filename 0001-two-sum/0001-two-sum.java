class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> c = new ArrayList<Integer>();
        int [] r = new int[2];
        
        for(int i = 0; i<nums.length; i++)
            c.add(target-nums[i]);
        
        for(int i = 0; i<nums.length; i++){
            if(c.contains(nums[i]) && c.indexOf(nums[i])!=i){
                r[0]=i;
                r[1]=c.indexOf(nums[i]);
                break;
            }
        }
//3 2 4 t6
        
        return r;
    }
}