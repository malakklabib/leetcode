class State {
    int node;
    int steps;
    public State(int node, int steps) {
        this.node = node;
        this.steps = steps;
    }
}
class Solution {
    public int snakesAndLadders(int[][] board) {
        Map<Integer, Integer> grid = new HashMap<>();
        int n = board.length;
        int var = -1, start = n-1;
        int node = 1;
        for(int i = n-1; i>=0; i--){
            var = -var;
            start = n-1 - start;
            for(int j = start; j < n && j>=0; j+=var) {
                grid.put(node, board[i][j]);
                node++;
            }
        }
        
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(1, 0));
        
        boolean[] seen = new boolean[n*n+1];
        seen[1] = true;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i++) {
                State state = queue.remove();
                node = state.node;
                int steps = state.steps;
                if(node==n*n)
                    return steps;
                
                for(int j = node+1; j <= Math.min(node+6, n*n); j++) {
                    if(!seen[j]) {
                        seen[j] = true;
                        int next = grid.get(j)==-1? j : grid.get(j);
                        queue.add(new State(next, steps+1));
                    }
                }
            }
        }
        return -1;
    }
}