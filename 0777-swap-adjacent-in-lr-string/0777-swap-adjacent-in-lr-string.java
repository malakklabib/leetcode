class Solution {
    public boolean canTransform(String s, String e) {
        if(!s.replace("X", "").equals(e.replace("X","")))
            return false;
        
        int p1 = 0, p2 = 0;
        while(p1 < s.length() && p2 < e.length()){
            if(p1 < s.length() && s.charAt(p1)=='X'){
                p1++;
                continue;
            }
            if(p2 < e.length() && e.charAt(p2)=='X'){
                p2++;
                continue;
            }
            if((s.charAt(p1)=='R' && e.charAt(p2)=='R' && p1 <= p2)
              || (s.charAt(p1)=='L' && e.charAt(p2)=='L' && p1 >= p2)){
                p1++;
                p2++;
            }
            else
                return false;
        }
        return true;
    }
}