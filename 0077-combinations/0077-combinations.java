class Solution {
    int n, k;
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        
        backtrack(1, new ArrayList());
        
        return res;
    }
    public void backtrack(int j, List<Integer> curr){
        if(curr.size()==k){
            res.add(new ArrayList(curr));
            return;
        }
        for(int i = j; i < n+1; i++){
            curr.add(i);
            backtrack(i+1, curr);
            curr.remove(curr.size()-1);
        }
    }
}