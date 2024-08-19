class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        long rem1 = Integer.MAX_VALUE;
        long rem2 = Integer.MAX_VALUE;
        for(int num: nums){
            sum+=num;
            if(num%3==1){
                rem2 = Math.min(rem2,rem1+num);
                rem1 = Math.min(rem1,num);
            }
            else if(num%3==2){
                rem1 = Math.min(rem1,rem2+num);
                rem2 = Math.min(rem2,num);
            }
        }
        return sum%3==0? sum : sum%3==1? sum-(int)rem1 : sum-(int)rem2;
    }
}