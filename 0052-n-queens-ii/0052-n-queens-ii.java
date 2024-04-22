class Solution {
    int ans = 0;
    int n;
    public int totalNQueens(int n) {
        this.n = n;
        backtrack(0, new HashSet(), new HashSet(), new HashSet());
        return ans;
    }
    public void backtrack(int i, Set<Integer> occupiedCol, Set<Integer> occupiedDi, Set<Integer> occupiedAnti){
        if(i == n){
            ans++;
            return;
        }
        for(int l = 0; l < n; l++){
            if(occupiedCol.contains(l) || occupiedDi.contains(i-l) || occupiedAnti.contains(i+l))
                continue;
            occupiedCol.add(l);
            occupiedDi.add(i-l);
            occupiedAnti.add(i+l);
            backtrack(i+1, occupiedCol, occupiedDi, occupiedAnti);
            occupiedCol.remove(l);
            occupiedDi.remove(i-l);
            occupiedAnti.remove(i+l);
        }
    }
}