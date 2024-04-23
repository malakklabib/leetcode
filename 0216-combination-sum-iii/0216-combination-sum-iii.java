class Solution {
    List<List<Integer>> res = new ArrayList();
    int k, n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.k = k;
        this.n = n;
        backtrack(1, 0, new ArrayList());
        return res;
    }
    public void backtrack(int i, int currSum, List<Integer> curr){
        if(curr.size()==k && currSum==n){
            res.add(new ArrayList(curr));
            return;
        }
        for(int j = i; j < 10; j++){
            if(currSum + j <= n){
                curr.add(j);
                backtrack(j+1, currSum+j, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
}