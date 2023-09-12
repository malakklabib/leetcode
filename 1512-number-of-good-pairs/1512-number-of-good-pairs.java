class Solution {
    public int numIdenticalPairs(int[] nums) {
        if(nums.length==1)
            return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int res = 0;
        for(int k: map.keySet()){
            int n = map.get(k).size();
            res+= n*(n-1)/2;
        }
        return res;
    }
}