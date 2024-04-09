class Solution {
    int ans = 0;
    String s;
    public int countSubstrings(String s) {
        this.s = s;
        for(int i = 0; i < s.length(); i++) {
            checkPal(i,i);
            checkPal(i,i+1);
        }
        return ans;
    }
    public void checkPal(int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l)==s.charAt(r)){
            ans++;
            l--;
            r++;
        }
    }
}