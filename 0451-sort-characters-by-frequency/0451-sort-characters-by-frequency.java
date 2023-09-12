class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(char c : arr)
            map.put(c, map.getOrDefault(c, 0) + 1);
        StringBuilder sb = new StringBuilder();
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue));
        for(Map.Entry<Character, Integer> m : list)
                for(int i = 0; i < m.getValue(); i++)
                    sb.append(m.getKey());
        return sb.reverse().toString();
    }
}