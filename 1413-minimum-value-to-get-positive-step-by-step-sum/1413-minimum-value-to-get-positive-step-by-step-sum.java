class Solution {
    public int minStartValue(int[] nums) {
        int a = 0;
        int[] p = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            a+=nums[i];
            p[i]=a;
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < p.length; i++){
            if(min > p[i])
                min = p[i];
        }
        return 1-min < 1? 1: 1-min;
    }
}