class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        
        Map<Character, Integer> counts = new HashMap<>();
        for(char c: t.toCharArray())
            counts.put(c, counts.getOrDefault(c,0)+1);
        
        int left = 0;
        Map<Character, Integer> countsWind = new HashMap<>();
        int have = 0;
        int need = counts.size();
        int i1 = 0, i2 = 0;
        int minLen = Integer.MAX_VALUE;

        
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            countsWind.put(c, countsWind.getOrDefault(c,0)+1);
            
            if(counts.containsKey(c) && counts.get(c).intValue() == countsWind.get(c).intValue())
                have++;
            
            while(have == need){
                if(minLen > right-left+1){
                    minLen = right-left+1;
                    i1 = left;
                    i2 = right+1;
                }
                c = s.charAt(left);
                countsWind.put(c,countsWind.get(c)-1);
                if(counts.containsKey(c) && counts.get(c).intValue() > countsWind.get(c).intValue())
                    have--;
                left++;
            }
        }
        
        return s.substring(i1,i2);
    }
}