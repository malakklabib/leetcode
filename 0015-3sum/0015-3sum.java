class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int p1 = 1, p2 = nums.length-1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            int m = nums[i];
            p1 = i+1;
            p2 = nums.length-1;
            while(p1<p2){
                int f = nums[p1], l = nums[p2];
                if(p1 > i+1 && f==nums[p1-1]){
                    p1++;
                    continue;
                }
                if(p2 < nums.length-1 && l==nums[p2+1]){
                    p2--;
                    continue;
                }
                if(f + l + m == 0){
                    tmp.add(m);
                    tmp.add(f);
                    tmp.add(l);
                    res.add(tmp);
                    tmp = new ArrayList<>();
                    p1++;
                }
                else if(f + l + m < 0)
                    p1++;
                else 
                    p2--;
            }
        }
        return res;
    } // -4 -1 -1 0 1 2 
}