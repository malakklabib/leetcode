class Solution {
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    char[][] board;
    String word;
    int m,n;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(backtrack(i,j,0))
                    return true;
            }
        }
        return false;
    }
    public boolean backtrack(int i, int j, int index){
        if(word.charAt(index)!=board[i][j])
            return false;
        
        char tmp = board[i][j];
        board[i][j] = '#';
        if(index==word.length()-1)
            return true;
        
        boolean ans = false;
        for(int[] direction: directions){
            int row = i + direction[0];
            int column = j + direction[1];
            if(valid(row,column) && backtrack(row, column, index+1))
                return true;
        }
        board[i][j] = tmp;
        return false;
    }
    public boolean valid(int i, int j) {
        return 0 <= i && i < m && 0 <= j && j < n && board[i][j]!='#';
    }
}