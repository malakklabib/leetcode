class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int n = spells.length;
        int[] pairs = new int[n];
        for(int i = 0; i < n; i++){
            int index = check(success, spells[i], potions);
            pairs[i] = m-index;
        }
        return pairs;
    }
    public int check(long min, int spell, int[] potions){
        int low = 0, high = potions.length-1;
        while(low <= high){
            int mid = (high-low)/2 + low;
            long prod = (long) potions[mid]*spell;
            if(prod < min)
                low = mid + 1;
            else if(prod >= min)
                high = mid - 1;
        }
        return low;
    }
}