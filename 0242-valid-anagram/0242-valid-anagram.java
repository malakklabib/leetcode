class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        Map<Character, Integer> counts = new HashMap<>();
        Map<Character, Integer> counts2 = new HashMap<>();
        for(char c: s.toCharArray())
            counts.put(c,counts.getOrDefault(c, 1)+1);
        for(char c: t.toCharArray()) 
            counts2.put(c,counts2.getOrDefault(c, 1)+1);
        return counts.equals(counts2);
    }
}