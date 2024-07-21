class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        
        int[][] res = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(rowSum[i] < colSum[j]){
                    res[i][j] = rowSum[i];
                    rowSum[i] = 0;
                    colSum[j]-=res[i][j];
                }
                else{
                    res[i][j] = colSum[j];
                    colSum[j] = 0;
                    rowSum[i]-=res[i][j];
                }
            }
        }
        return res;
    }
}