class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < paths.size(); i++){
            map.put(paths.get(i).get(0), paths.get(i).get(1));
        }
        for(String v : map.values())
            if(!map.containsKey(v))
                return v;
        return "";
    }
}