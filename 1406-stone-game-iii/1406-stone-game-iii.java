class Solution {
    int[] stones;
    Integer[] memo;
    public String stoneGameIII(int[] stoneValue) {
        memo = new Integer[stoneValue.length];
        stones = stoneValue;
        int score = dp(0);
        if(score > 0)
            return "Alice";
        if(score < 0)
            return "Bob";
        return "Tie";
    }
    public int dp(int i){
        if(i >= stones.length)
            return 0;
        
        if(memo[i]!=null)
            return memo[i];
        
        int takeOne = stones[i] - dp(i+1);
        int takeTwo = Integer.MIN_VALUE, takeThree = Integer.MIN_VALUE;
        if(i < stones.length-1)
            takeTwo = stones[i] + stones[i+1] - dp(i+2);
        if(i < stones.length-2)
            takeThree = stones[i] + stones[i+1] + stones[i+2] - dp(i+3);
        return memo[i] = Math.max(takeOne, Math.max(takeTwo, takeThree));
    }
}