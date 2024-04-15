class Solution {
    public int totalFruit(int[] fruits) {
        int l = 0;
        Map<Integer, Integer> counts = new HashMap<>();
        int len = 0;
        for(int r = 0; r < fruits.length; r++){
            counts.put(fruits[r], counts.getOrDefault(fruits[r],0)+1);
            while(counts.size() > 2){
                counts.put(fruits[l], counts.get(fruits[l])-1);
                if(counts.get(fruits[l])==0)
                    counts.remove(fruits[l]);
                l++;
            }
            len = Math.max(len, r-l+1);
        }
        return len;
        
    }
}