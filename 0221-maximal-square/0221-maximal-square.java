class Solution {
    int m, n;
    int[][] matrix;
    Integer[][] memo;
    public int maximalSquare(char[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;

        int ans = 0;
        this.matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                this.matrix[i][j] = matrix[i][j] - '0';
                ans = Math.max(ans, this.matrix[i][j]);
            }
        }
        
        if(m*n==0) 
            return ans;
        
        memo = new Integer[m][n];
        
        dp(0,0);
        
        for(Integer[] row: memo)
            for(Integer cell : row)
                if(cell!=null)
                    ans = Math.max(ans,cell);
        return ans*ans;
    }
    
    public int dp(int i, int j){
        if(i > m-1 || j > n-1)
            return 0;
        
        if(i==m-1 || j==n-1)
            return memo[i][j] = matrix[i][j];
        
        if(memo[i][j]!=null)
            return memo[i][j];
        
        int d1 = dp(i,j+1);
        int d2 = dp(i+1,j);
        int d3 = dp(i+1,j+1);
        
        if(matrix[i][j]==1)
            memo[i][j] = Math.min(d1,Math.min(d2,d3)) + 1;
        else
            memo[i][j] = 0;
        
        return memo[i][j];
    }
}