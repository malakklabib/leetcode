class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        int ind = 0;
        for(int i = 0; i < gas.length; i++)
            sum+= gas[i]-cost[i];
        if(sum < 0)
            return -1;
        
        sum = 0;
        for(int i = 0; i < gas.length; i++){
            sum += gas[i] - cost[i];
            if(sum < 0){
                sum = 0;
                ind = i + 1;
            }
        }
        return ind;
    }
}