class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] freq = new int[26];
        int[] queryFn = new int[queries.length];
        int[] wordsFn = new int[words.length];

        for(int i = 0; i < queries.length; i++){
            String query = queries[i];
            char smallestChar = 'z';
            for(char c: query.toCharArray()){
                freq[c-'a']++;
                smallestChar = (char) Math.min((int) smallestChar, (int) c);
            }
            queryFn[i] = freq[smallestChar-'a'];
            Arrays.fill(freq, 0);
        }
        
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            char smallestChar = 'z';
            for(char c: word.toCharArray()){
                freq[c-'a']++;
                smallestChar = (char) Math.min((int) smallestChar, (int) c);
            }
            wordsFn[i] = freq[smallestChar-'a'];
            Arrays.fill(freq, 0);
        }
        
        Arrays.sort(wordsFn);
        for(int i = 0; i < queryFn.length; i++){
            int fq = queryFn[i];
            queryFn[i] = 0;
            for(int j =  wordsFn.length-1; j >= 0 && fq < wordsFn[j]; j--)
                queryFn[i]++;
        }
        
        return queryFn;
    }
}