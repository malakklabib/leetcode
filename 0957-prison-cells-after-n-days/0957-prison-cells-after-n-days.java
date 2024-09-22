class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        boolean hasCycle = false;
        int cycleLen = 0;
        Set<String> seen = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            int[] newCells = getNextState(cells);
            String state = Arrays.toString(newCells);
            
            if(!seen.contains(state)){
                seen.add(state);
                cycleLen++;
            }
            else{
                hasCycle = true;
                break;
            }
            
            cells = newCells;
        }
        
        if(hasCycle){
            n = n % cycleLen;
            
            for(int i = 0; i < n; i++)
                cells = getNextState(cells);
        }
        
        return cells;
    }
    
    private int[] getNextState(int[] cells){
        int[] res = new int[8];
        
        for(int i = 1; i < 7; i++)
            res[i] = cells[i-1] == cells[i+1]? 1 : 0;
        
        return res;
    }
}