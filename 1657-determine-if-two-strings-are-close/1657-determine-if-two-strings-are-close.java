class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        Map<Character, Integer> w1Counts = new HashMap<>();
        Map<Character, Integer> w2Counts = new HashMap<>(); 
        for(char c: word1.toCharArray())
            w1Counts.put(c, w1Counts.getOrDefault(c, 0) + 1);
        for(char c: word2.toCharArray())
            w2Counts.put(c, w2Counts.getOrDefault(c, 0) + 1);
        List<Integer> w1Values = new ArrayList<>(w1Counts.values());
        List<Integer> w2Values = new ArrayList<>(w2Counts.values());
        Collections.sort(w1Values);
        Collections.sort(w2Values);
        return w1Counts.keySet().equals(w2Counts.keySet()) && w1Values.equals(w2Values);
            

    }
}