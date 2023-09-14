class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> index = new HashMap<>();
        int sum = 0, score = Integer.MIN_VALUE, start = 0;
        for(int i= 0; i < nums.length; i++){
            if(index.containsKey(nums[i])){
                int dup = index.get(nums[i]);
                while(start <= dup){
                    sum-=nums[start];
                    index.remove(nums[start]);
                    start++;
                }
            }
            sum+=nums[i];
            score = Math.max(sum, score);
            index.put(nums[i], i);  
        }
        return score;
    }
}