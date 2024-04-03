class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int n = s.length();
        int start = 0, end = n-1;
        while(start<end){
            if(!('a'<=s.charAt(start) && s.charAt(start)<='z' || '0'<=s.charAt(start) && s.charAt(start)<='9')){
                start++;
                continue;
            }
            if(!('a'<=s.charAt(end) && s.charAt(end)<='z' || '0'<=s.charAt(end) && s.charAt(end)<='9')){
                end--;
                continue;
            }
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}