class Solution {
    List<List<Integer>> res = new ArrayList();
    int[][] graph;
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        n = graph.length;
        
        backtrack(0, new ArrayList());
        
        return res;
    }
    
    public void backtrack(int node, List<Integer> curr){
        curr.add(node);
        if(node==n-1){
            res.add(new ArrayList(curr));
            return;
        }
        
        for(int neighbor: graph[node]){
            backtrack(neighbor, curr);
            curr.remove(curr.size()-1);
        }
    }
}