class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        
        Arrays.sort(hand);
        
        Map<Integer, Integer> counts = new HashMap<>();
        
        for(int num: hand)
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        
        for(int num: hand){
            if(counts.getOrDefault(num, 0) == 0)
                continue;
            
            counts.put(num, counts.get(num)-1);
            for(int i = 1; i < groupSize; i++){
                if(counts.getOrDefault(num+i, 0) > 0)
                    counts.put(num+i, counts.get(num+i)-1);
                else
                    return false;
            }
        }
        
        return true;
    }
}