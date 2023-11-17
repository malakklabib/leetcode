class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        return dp(n);
    }
    public int dp(int i){
        if(i==1 || i==2)
            return i;
        if(memo.containsKey(i))
            return memo.get(i);
        memo.put(i, dp(i-1) + dp(i-2));
        return memo.get(i);
    }
}