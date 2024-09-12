class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] queryFn = getFrequencies(queries);
        int[] wordsFn = getFrequencies(words);
        
        Arrays.sort(wordsFn);
        for(int i = 0; i < queryFn.length; i++){
            int fq = queryFn[i];
            // queryFn[i] = 0;
            int l = 0, r = wordsFn.length-1;
            
            while(l <= r){
                int m = (r-l)/2 + l;
                if(fq >= wordsFn[m])
                    l = m + 1;
                else
                    r = m - 1;
            }
            queryFn[i] = wordsFn.length-l;
        }
        
        return queryFn;
    }
    public int[] getFrequencies(String[] strs){
        int[] freq = new int[26];
        int[] fn = new int[strs.length];
        
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            char smallestChar = 'z';
            for(char c: str.toCharArray()){
                freq[c-'a']++;
                smallestChar = (char) Math.min((int) smallestChar, (int) c);
            }
            fn[i] = freq[smallestChar-'a'];
            Arrays.fill(freq, 0);
        }
        
        return fn;
    }
}