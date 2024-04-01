class State{
    int row;
    int col;
    int steps;
    public State(int row, int col, int steps){
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}
class Solution {
    int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] seen;
    int m, n, entRow, entCol;
    public int nearestExit(char[][] maze, int[] entrance) {
        m = maze.length;
        n = maze[0].length;
        seen = new boolean[m][n];
        entRow = entrance[0];
        entCol = entrance[1];
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(entRow, entCol, 0));
        seen[entRow][entCol] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                State state = queue.remove();
                int row = state.row,
                col = state.col,
                steps = state.steps;
                for(int[] direction: directions) {
                    int newRow = direction[0] + row,
                    newCol = direction[1] + col;
                    if(valid(newRow, newCol, maze) && !seen[newRow][newCol]) {
                        if(isExit(newRow, newCol))
                            return ++steps;
                        seen[newRow][newCol] = true;
                        queue.add(new State(newRow, newCol, steps+1));
                    }
                }
            }
        }
        return -1;
    }
    public boolean valid(int row, int col, char[][] maze) {
        return 0<=row && row <m && 0<=col && col<n && maze[row][col]=='.';
    }
    public boolean isExit(int row, int col) {
        return row==0 || row==m-1 || col==0 || col==n-1;
    }
}