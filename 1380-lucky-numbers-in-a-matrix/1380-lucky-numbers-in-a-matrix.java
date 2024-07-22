class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        List<Integer> res = new ArrayList();
        
        int[] minRow = new int[n];
        int[] maxCol = new int[m];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        Arrays.fill(maxCol, Integer.MIN_VALUE);
        
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j])
                    res.add(maxCol[j]);
            }
        }
        
        return res;
    }
}