class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        
        int row = 0, col = n-1;
        while(col >= 0 && row < m){
            if(target < matrix[row][col]){
                col--;
            }
            else if(target > matrix[row][col]){
                row++;
            }
            else
                return true;
        }
        
        return false;
    }
}