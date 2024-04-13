class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0, r = m*n - 1;
        
        while(l <= r){
            int mid = (r-l)/2 + l;
            int i = mid/n;
            int j = mid%n;
            if(matrix[i][j]==target)
                return true;
            if(target > matrix[i][j])
                l = mid + 1;
            else
                r = mid - 1; 
        }
        
        return false;
    }
}