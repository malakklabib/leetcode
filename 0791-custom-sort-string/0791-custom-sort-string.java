class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++)
            map.put(order.charAt(i), i);
        char[] arr = s.toCharArray();
        Character[] arrBoxed = new Character[arr.length];
        for (int i = 0; i < arr.length; i++)
            arrBoxed[i] = arr[i];
        Arrays.sort(arrBoxed, (a, b) -> map.containsKey(a) && map.containsKey(b)? map.get(a) - map.get(b) : 
                                        map.containsKey(a)? 1 : 
                                        map.containsKey(b)? -1 : 0);
        StringBuilder result = new StringBuilder();
        for (Character c : arrBoxed)
            result.append(c);
        return result.toString();
    }
}