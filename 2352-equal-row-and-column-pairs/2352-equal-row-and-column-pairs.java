class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        Map<Integer, List<Integer>> rowsMap = new HashMap();
        Map<Integer, List<Integer>> colsMap = new HashMap();
        for(int i = 0; i < n; i++){
            rowsMap.put(i,new ArrayList());
            for(int j = 0; j < n; j++){
                rowsMap.get(i).add(grid[i][j]);
                if(!colsMap.containsKey(j))
                    colsMap.put(j,new ArrayList());
                colsMap.get(j).add(grid[i][j]);
            }
        }
        
        for(int key1: rowsMap.keySet()){
            for(int key2: colsMap.keySet()){
                if(colsMap.get(key2).equals(rowsMap.get(key1)))
                    ans++;
            }
        }
        return ans;
    }
}