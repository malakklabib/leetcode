class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freq = new int[26];
        int[] queryFn = new int[queries.length];
        int[] wordsFn = new int[words.length];

        getFrequencies(queries, freq, queryFn);
        getFrequencies(words, freq, wordsFn);
        
        Arrays.sort(wordsFn);
        for(int i = 0; i < queryFn.length; i++){
            int fq = queryFn[i];
            queryFn[i] = 0;
            for(int j =  wordsFn.length-1; j >= 0 && fq < wordsFn[j]; j--)
                queryFn[i]++;
        }
        
        return queryFn;
    }
    public void getFrequencies(String[] strs, int[] freq, int[] fn){
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
    }
}