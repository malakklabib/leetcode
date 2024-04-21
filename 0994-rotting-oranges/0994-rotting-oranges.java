class Solution {
    int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int[][] grid;
    int m,n;
    public int orangesRotting(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        
        Queue<String> q = new LinkedList();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j]==2)
                    q.add(encode(i,j));
            }
        }
        
        int mins = 0;
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                int[] pos = decode(q.remove());
                int row = pos[0];
                int col = pos[1];
                for(int[] direction: directions){
                    int newRow = direction[0] + row;
                    int newCol = direction[1] + col;
                    if(valid(newRow, newCol)){
                        grid[newRow][newCol] = 2;
                        q.add(encode(newRow,newCol));
                    }
                }
            }
            if(!q.isEmpty())
                mins++;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return mins;
    }
    
    public String encode(int i, int j){
        return i+" "+j;
    }
    public int[] decode(String s){
        String[] arr = s.split(" ");
        int[] res = new int[2];
        res[0] = Integer.parseInt(arr[0]);        
        res[1] = Integer.parseInt(arr[1]);        
        return res; 
    }
    public boolean valid(int i, int j){
        return 0 <= i && i < m && 0 <= j && j < n && grid[i][j] == 1;
    }
}