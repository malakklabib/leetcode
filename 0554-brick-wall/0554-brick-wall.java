class Solution {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<List<Integer>> pref = new ArrayList<List<Integer>>();
        int n = wall.size();
        for(int i = 0; i < wall.size(); i++){
            int sum = 0;
            List<Integer> tmp = new ArrayList<Integer>();
            for(int j = 0; j < wall.get(i).size()-1; j++){
                sum+=wall.get(i).get(j);
                tmp.add(sum);
            }
            pref.add(tmp);
        }
        
        for(List<Integer> row: pref){
            for(int brick: row)
                counts.put(brick,counts.getOrDefault(brick, 0)+1);
        }
        
        int max = 0;
        for(int key: counts.keySet()){
            int occurrences = counts.get(key);
            max = Math.max(occurrences, max);
        }
        
        return n-max;
    }/*
    1 3 5 6
    3 4 6
    1 4 6
    2 6
    3 4 6
    3 4 6
    1 4 5 6
    */
}