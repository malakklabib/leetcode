class Solution {
    int[] arr;
    Boolean[][] memo;
    public boolean canPartition(int[] arr) {
        this.arr = arr;
        int sum = 0;
        for(int num : arr)
            sum+=num;
        
        if(sum%2!=0)
            return false;
        
        sum/=2;
        memo = new Boolean[arr.length][sum+1];
        
        return dp(0, sum);
    }
        
    public boolean dp(int i, int sum){
        if(sum==0)
            return true;
        
        if(i==arr.length)
            return false;
    
        if(memo[i][sum]!=null)
            return memo[i][sum];
    
        if(sum >= arr[i])
            memo[i][sum] = dp(i+1,sum-arr[i]) || dp(i+1,sum);
        else
            memo[i][sum] = dp(i+1,sum);
    
        return memo[i][sum];
    
    }
}