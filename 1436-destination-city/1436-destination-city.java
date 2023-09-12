class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> from = new HashSet<>();
        Set<String> to = new HashSet<>();
        for(int i = 0; i < paths.size(); i++){
            from.add(paths.get(i).get(0));
            to.add(paths.get(i).get(1));
        }
        for(String i : to)
            if(!from.contains(i))
                return i;
        return "";
    }
}