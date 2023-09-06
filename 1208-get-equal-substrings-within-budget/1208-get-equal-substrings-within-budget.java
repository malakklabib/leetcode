class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        if(s.length() != t.length())
            return 0;
        int cost = 0;
        int len = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < s.length(); i++){
            cost+=Math.abs(s.charAt(i)-t.charAt(i));
            len++;
            if(cost>maxCost){
                cost-=Math.abs(s.charAt(i-len+1)-t.charAt(i-len+1));
                len--;
            }
            max = Math.max(len, max);
        }
        return max == Integer.MIN_VALUE? 0 : max;
    }
}