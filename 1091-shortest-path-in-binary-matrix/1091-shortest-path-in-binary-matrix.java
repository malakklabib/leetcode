class State {
    int row, col, level;
    public State(int row, int col, int level){
        this.row = row;
        this.col = col;
        this.level = level;
    }
}
public class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{1,1},{0,1},{0,-1},{-1,-1},{1,-1},{-1,1}};
    int n, m;
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1)
            return -1;
        n = grid.length;
        m = grid[0].length;
        boolean[][] seen = new boolean[n][n];
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0,0,1));
        seen[0][0] = true;
        while(!queue.isEmpty()) {
            State curr = queue.remove();
            int row = curr.row, col = curr.col, level = curr.level;
            if(row==n-1 && col==n-1)
                return level;
            for(int[] dir: directions) {
                int newRow = dir[0] + row, newCol = dir[1] + col;
                if(valid(newRow, newCol, grid) && !seen[newRow][newCol]) {
                    seen[newRow][newCol] = true;
                    queue.add(new State(newRow, newCol, level+1));
                }
            }
        }
        return -1;
    }
    public boolean valid(int row, int col, int[][] grid) {
        return 0<=row && row<n && 0<=col && col<m && grid[row][col]==0;
    }
}