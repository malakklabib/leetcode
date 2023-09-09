class Solution {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> counts = new HashMap<>();
        for(char c: text.toCharArray())
            if(c=='b' || c=='a' || c=='l' || c=='o' || c=='n')
                counts.put(c, counts.getOrDefault(c, 0) + 1);
        int min = Integer.MAX_VALUE;
        for(char c : counts.keySet()){
            if(c == 'l' || c == 'o')
                min = Math.min(min, counts.get(c)/2);
            else
                min = Math.min(min, counts.get(c));
        }
        if(counts.getOrDefault('l', 0)>=2*min && counts.getOrDefault('o', 0)>=2*min && 
           counts.getOrDefault('b', 0)>=min && counts.getOrDefault('a', 0)>=min && counts.getOrDefault('n', 0)>=min)
            return min;
        return 0;
    }
}