class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        for(char c: text.toCharArray())
            if(c=='b' || c=='a' || c=='l' || c=='o' || c=='n')
                counts.put(c, counts.getOrDefault(c, 0) + 1);
        return Math.min(counts.getOrDefault('b', 0), Math.min(counts.getOrDefault('a', 0),                  Math.min(counts.getOrDefault('n', 0), Math.min(counts.getOrDefault('l', 0)/2, counts.getOrDefault('o', 0)/2))));
    }
}