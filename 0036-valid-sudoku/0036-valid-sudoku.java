class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c=='.')
                    continue;
                
                String row = c + " in row " + i;
                String col = c + " in col " + j;
                String box = c + " in box " + (i/3)*3 + (j/3);
                
                if(!set.add(row) || !set.add(col) || !set.add(box))
                    return false;
            }
        }
        return true;
    }
}