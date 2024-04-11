class Solution {
    List<List<Integer>> memo;
    List<List<Integer>> tri;
    public int minimumTotal(List<List<Integer>> triangle) {
        memo = new ArrayList<List<Integer>>();
        
        for(List<Integer> row: triangle)
            memo.add(new ArrayList<>(Collections.nCopies(row.size(),null)));
        
        tri = triangle;
        return dp(0,0);
    }
    
    public int dp(int i, int j){
        if(i==tri.size()-1){
            memo.get(i).set(j, tri.get(i).get(j));
            return memo.get(i).get(j);
        }
        
        if(memo.get(i).get(j)!=null)
            return memo.get(i).get(j);
        
        int same = dp(i+1,j);
        int next = dp(i+1,j+1);
        int ans = tri.get(i).get(j) + Math.min(same,next);
        
        memo.get(i).set(j, ans);
        return memo.get(i).get(j);
    }
}