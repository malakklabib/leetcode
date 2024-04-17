class Solution {
    int n;
    int[] nums;
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        n = nums.length;
        backtrack(new ArrayList<>(), 0);
        return res;
    }
    public void backtrack(List<Integer> curr, int i){
        if(i > n)
            return;
        
        res.add(new ArrayList(curr));
        for(int j = i; j < n; j++){
            curr.add(nums[j]);
            backtrack(curr, j+1);
            curr.remove(curr.size()-1);
        }
    }
}