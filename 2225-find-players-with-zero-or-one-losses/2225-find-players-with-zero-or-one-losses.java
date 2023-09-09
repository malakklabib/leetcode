class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int[] i: matches){
            counts.put(i[0], counts.getOrDefault(i[0], 0)==0? 0 : counts.get(i[0]));
            counts.put(i[1], counts.getOrDefault(i[1], 0)+1);
        }
        Set<Integer> noMatches = new TreeSet<Integer>();
        Set<Integer> oneMatch = new TreeSet<Integer>();
        for(int i: counts.keySet()){
            if(counts.get(i) == 0)
                noMatches.add(i);
            else if(counts.get(i) == 1)
                oneMatch.add(i);
        }
        List<Integer> none = new ArrayList<Integer>(noMatches);
        List<Integer> one = new ArrayList<Integer>(oneMatch);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(none);
        res.add(one);
        return res;
    }
}