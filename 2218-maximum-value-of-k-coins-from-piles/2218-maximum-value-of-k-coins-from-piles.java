class Solution {
    List<List<Integer>> piles;
    int[][] memo;
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        this.piles=piles;
        memo=new int[piles.size()][k+1];
        for(int i = 0; i < piles.size(); i++)
            Arrays.fill(memo[i], -1);
        return dp(0, k);
    }
    public int dp(int i, int rem){
        if(i==piles.size() || rem==0)
            return 0;
        if(memo[i][rem]!=-1)
            return memo[i][rem];
        int sum = 0;
        int ans = dp(i+1, rem);
        for(int j = 0; j < Math.min(piles.get(i).size(), rem); j++){
            sum+=piles.get(i).get(j);
            ans = Math.max(ans, sum + dp(i+1, rem-j-1));
        }
        memo[i][rem] = ans;
        return memo[i][rem];

    }
}