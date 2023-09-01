class Solution {
    public void reverseString(char[] s) {
        int a = 0, b = s.length-1;
        char tmp = s[0];
        while(a < b){
            tmp = s[a];
            s[a] = s[b];
            s[b] = tmp;
            a++;
            b--;
        }
    }
}