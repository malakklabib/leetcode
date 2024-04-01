class State{
    int node;
    char color;
    int steps;
    public State(int node, char color, int steps) {
        this.node = node;
        this.color = color;
        this.steps = steps;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, 'r', 0));
        queue.add(new State(0, 'b', 0));
        
        boolean[][] seen = new boolean[n][2];
        seen[0][0] = true;
        seen[0][1] = true;
        Arrays.fill(ans,Integer.MAX_VALUE);

        Map<Integer, List<Integer>> rg = new HashMap<>();
        Map<Integer, List<Integer>> bg = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            rg.put(i, new ArrayList<>());            
            bg.put(i, new ArrayList<>());
        }
        
        for(int[] edge: redEdges)
            rg.get(edge[0]).add(edge[1]);
        
        for(int[] edge: blueEdges)
            bg.get(edge[0]).add(edge[1]);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                State state = queue.remove();
                int node = state.node;
                char color = state.color;
                int steps = state.steps;
                ans[node] = Math.min(steps,ans[node]);
                if(color=='r'){
                    for(int neighbor: rg.get(node)) {
                        if(!seen[neighbor][0]) {
                            seen[neighbor][0] = true;
                            queue.add(new State(neighbor, 'b', steps+1));
                        }
                    }
                }
                else {
                    for(int neighbor: bg.get(node)) {
                        if(!seen[neighbor][1]) {
                            seen[neighbor][1] = true;
                            queue.add(new State(neighbor, 'r', steps+1));
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++)
            if(ans[i]==Integer.MAX_VALUE)
                ans[i] = -1;
        return ans;
    }
}