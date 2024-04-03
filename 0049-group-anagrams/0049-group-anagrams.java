class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> grps = new HashMap<>();
        for(String s: strs) {
            int[] alph = new int[26];
            for(char c: s.toCharArray())
                alph[c-'a']++;
            StringBuilder sb = new StringBuilder();
            for(int num: alph){
                sb.append(num);
                sb.append(" ");
            }
            String key = sb.toString();
            grps.computeIfAbsent(key, k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(grps.values());
       
    }
}