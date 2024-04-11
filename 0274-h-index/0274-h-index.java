class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        
        for(int i = n; i > 0; i--){
            int h = 0;
            for(int cit:citations){
                if(cit >= i)
                    h++;
            }
            if(h>=i)
                return i;
        }
        
        return 0;
    }
}