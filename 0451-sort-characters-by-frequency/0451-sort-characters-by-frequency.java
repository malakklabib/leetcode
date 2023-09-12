class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        List<List<Character>> list = new ArrayList<>();
        int maxFreq = Collections.max(map.values());
        for(int i = 0; i <= maxFreq; i++)
            list.add(new ArrayList<>());
        
        for(char k : map.keySet())
            list.get(map.get(k)).add(k);
        
        StringBuilder sb = new StringBuilder();
        for(int i = list.size()-1; i > 0; i--){
            for(char c: list.get(i))
                for(int j = 0; j < i; j++)
                    sb.append(c);
        }
        return sb.toString();
    }
}