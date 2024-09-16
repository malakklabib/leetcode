class Solution {
    public boolean isPossible(int[] nums) {
        if(nums.length < 3)
            return false;
        
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();
        for(int num: nums){
            counts.put(num, counts.getOrDefault(num, 0)+1);
        }
        
        for(int num: nums){
            if(counts.get(num) > 0){
                if(last.getOrDefault(num-1, 0) > 0){
                    counts.put(num, counts.get(num)-1);
                    last.put(num-1, last.get(num-1)-1);
                    last.put(num, last.getOrDefault(num, 0) + 1);
                }
                else if(counts.getOrDefault(num+1, 0) > 0 && counts.getOrDefault(num+2, 0) > 0){
                    last.put(num+2, last.getOrDefault(num+2, 0)+1);
                    counts.put(num, counts.get(num)-1);
                    counts.put(num+1, counts.get(num+1)-1);
                    counts.put(num+2, counts.get(num+2)-1);
                }
                else
                    return false;
            }
        }
        
        return true;
    }
}