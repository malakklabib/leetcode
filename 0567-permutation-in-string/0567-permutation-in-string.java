class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        int j = s1.length();
        for(int i = 0; j+i <= s2.length(); i++){
            if(check(s2.substring(i, j+i),s1))
                return true;
        }
        return false;
    }
    public static boolean check(String s, String t){
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        Arrays.sort(sa);
        Arrays.sort(ta);
        for(int i = 0; i < sa.length; i++)
            if(sa[i]!=ta[i])
                return false;
        return true;
    }
}