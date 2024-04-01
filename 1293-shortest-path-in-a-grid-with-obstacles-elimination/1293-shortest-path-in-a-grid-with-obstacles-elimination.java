class State {
    int row, col, steps, obst;
    public State(int row, int col, int steps, int obst) {
        this.row = row;
        this.col = col;
        this.steps = steps;
        this.obst = obst;
    }
}

class Solution {
    int m, n;
    int[][] directions = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    public int shortestPath(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        Queue<State> queue = new LinkedList<>();
        boolean[][][] seen = new boolean[m][n][k+1];
        queue.add(new State(0,0,0,0));
        seen[0][0][0] = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                State state = queue.remove();
                int row = state.row,
                col = state.col,
                steps = state.steps,
                obst = state.obst;
                if(row==m-1 && col==n-1)
                    return steps;
                for(int[] direction: directions) {
                    int newRow = row + direction[0],
                    newCol = col + direction[1];
                    if(valid(newRow,newCol) && !seen[newRow][newCol][obst]) {
                        seen[newRow][newCol][obst] = true;
                        if(grid[newRow][newCol]==1 && obst < k)
                            queue.add(new State(newRow,newCol,steps+1,obst+1));
                        else if(grid[newRow][newCol]==0)
                            queue.add(new State(newRow,newCol,steps+1,obst));
                    }
                }
            }
        }
        return -1;
    }
    public boolean valid(int row, int col) {
        return 0<=row && row<m && 0<=col && col<n;
    }
}