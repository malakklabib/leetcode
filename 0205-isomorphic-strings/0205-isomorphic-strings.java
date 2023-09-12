class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, List<Integer>> sm = new HashMap<>();        
        Map<Character, List<Integer>> tm = new HashMap<>();
        int i = 0;
        for(char c: s.toCharArray()){
            if(!sm.containsKey(c))
                sm.put(c, new ArrayList<>());
            sm.get(c).add(i);
            i++;
        }
        i = 0;
        for(char c: t.toCharArray()){
            if(!tm.containsKey(c))
                tm.put(c, new ArrayList<>());
            tm.get(c).add(i);
            i++;
        }
        for(List<Integer> l: tm.values()){
            if(!sm.containsValue(l))
                return false;
        }
        return true;
    }
}