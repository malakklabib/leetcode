class Solution {
    public boolean isSubsequence(String s, String t) {
        int s1 = 0, t1 = 0;
        while(t1 < t.length() && s1 < s.length()){
            if(s.charAt(s1) != t.charAt(t1))
                t1++;
            else{
                s1++;
                t1++;
            }
        }
        if(s1!=s.length())
            return false;
        return true;
    }
}