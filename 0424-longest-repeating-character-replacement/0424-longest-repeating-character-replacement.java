class Solution {
    public int characterReplacement(String s, int k) {
        int maxCount = 0;
        int l = 0, r = 0;
        int res = 0;
        Map<Character, Integer> counts = new HashMap<>();
        while(r < s.length()){
            char c = s.charAt(r);
            counts.put(c, counts.getOrDefault(c,0)+1);
            maxCount = Math.max(maxCount, counts.get(c));
            while((r-l+1)-maxCount > k) {
                c = s.charAt(l);
                counts.put(c, counts.get(c)-1);
                l++;
            }
            res = Math.max(res,r-l+1);
            r++;
        }
        return res;
    }// AABBBBA
}