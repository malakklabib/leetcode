class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] p = new int[nums.length];
        int sum = 0;
        for(int i= 0; i < nums.length; i++){
            sum+=nums[i];
            p[i] = sum;
        } 
        int count = 0;
        for(int i=0; i < p.length; i++){
            if(p[i]>=goal){
                for(int j = 0; j < i ; j++)
                    if(p[i]-p[j]==goal)
                        count++;
            }
            if(p[i]==goal)
                count++;
        }
        return count;
    }
}