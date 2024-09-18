class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastSeen = new int[26];
        for(int i = 0; i < s.length(); i++)
            lastSeen[s.charAt(i)-'a'] = i;
        
        int currFirst = 0, currLast = 0;
        List<Integer> divSizes = new ArrayList<>();
        
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            currLast = Math.max(currLast, lastSeen[curr-'a']);
            if(i == currLast){
                divSizes.add(currLast - currFirst + 1);
                currFirst = currLast+1;
            }
        }
        
        return divSizes;
    }
}