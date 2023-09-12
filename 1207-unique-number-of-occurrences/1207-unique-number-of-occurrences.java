class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : arr)
            map.put(i, map.getOrDefault(i, 0) + 1);
        Map<Integer, Integer> copy = new HashMap<>(map);
        for(int i : map.keySet()){
            int v = map.get(i);
            copy.remove(i);
            if(copy.containsValue(v))
                return false;
        }
        return true;
    }
}