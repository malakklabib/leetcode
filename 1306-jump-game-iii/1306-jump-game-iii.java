class Solution {
    boolean[] seen;
    int[] arr;
    public boolean canReach(int[] arr, int start) {
        seen = new boolean[arr.length];
        this.arr = arr;
        seen[start]=true;
        return dfs(start);
    }
    public boolean dfs(int node) {
        if(arr[node]==0)
            return true;
        boolean ans = false;
        for(int neighbor: getNeighbors(node)) {
            if(!seen[neighbor]) {
                seen[neighbor] = true;
                ans |= dfs(neighbor);
            }
        }
        return ans;
    }
    public List<Integer> getNeighbors(int node) {
        List<Integer> res = new ArrayList<>();
        if(node + arr[node] < arr.length)
            res.add(node+arr[node]);
        if(node - arr[node] >= 0)
            res.add(node-arr[node]);
        return res;
    }
}