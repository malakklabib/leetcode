class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int rotationsA = check(tops[0], tops, bottoms, n);  
        int rotationsB = check(bottoms[0], tops, bottoms, n);
        
        if(rotationsA == -1 && rotationsB == -1) return -1;
        if(rotationsA == -1) return rotationsB;
        if(rotationsB == -1) return rotationsA;
        
        return Math.min(rotationsA, rotationsB);
    }
    
    public int check(int target, int[] tops, int[] bottoms, int n) {
        int rotationsTop = 0, rotationsBottom = 0;
        
        for(int i = 0; i < n; i++) {
            if(tops[i] != target && bottoms[i] != target) return -1;
            else if(tops[i] != target) rotationsTop++;
            else if(bottoms[i] != target) rotationsBottom++;
        }
        
        return Math.min(rotationsTop, rotationsBottom);
    }
}
