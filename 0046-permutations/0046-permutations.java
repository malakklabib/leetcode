class Solution {
    int n;
    List<List<Integer>> res = new ArrayList();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        n = nums.length;
        backtrack(new ArrayList<>());
        return res;
    }
    public void backtrack(List<Integer> curr){
        if(curr.size()==n){
            res.add(new ArrayList(curr));
            return;
        }
        for(int num : nums){
            if(!curr.contains(num)){
                curr.add(num);
                backtrack(curr);
                curr.remove(curr.size()-1);
            }
        }
        return;
    }
}