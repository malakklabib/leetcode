class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> counts = new HashMap<>();
        Set<String> bannedSet = new HashSet<>();
        for(String word: banned)
            bannedSet.add(word);
        
        int maxCount = 1;
        for(String word: paragraph.split("[\\s!?',;.]+")){
            String lowercaseWord = word.toLowerCase();
            if(bannedSet.contains(lowercaseWord))
                continue;
            counts.put(lowercaseWord, counts.getOrDefault(lowercaseWord, 0) + 1);
            maxCount = Math.max(maxCount, counts.get(lowercaseWord));
        }
        
        for(Map.Entry<String, Integer> entry: counts.entrySet()){
            if(entry.getValue()==maxCount)
                return entry.getKey();
        }
        
        return "";
    }
}