class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges){
        boolean[] seen = new boolean[n];
        for(List<Integer> edge: edges)
            seen[edge.get(1)]=true;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++)
            if(!seen[i])
                ans.add(i);
        return ans;
    }
}