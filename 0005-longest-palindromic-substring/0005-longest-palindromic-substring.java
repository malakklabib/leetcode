class Solution {
    String s;
    int maxLen, start, end;
    public String longestPalindrome(String s) {
        this.s = s;
        maxLen = 1;
        start = 0;
        end = 0;
        for(int i = 0; i < s.length(); i++){
            checkPal(i, i);
            checkPal(i, i+1);
        }
        return s.substring(start, end+1);
    }
    public void checkPal(int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            if(r-l+1 > maxLen){
                maxLen = r-l+1;
                start = l;
                end = r;
            }
            l--;
            r++;
        }
    }
}