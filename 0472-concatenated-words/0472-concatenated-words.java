class Solution {
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(words));
        
        for(String word: words){
            int n = word.length();
            boolean[] dp = new boolean[n+1];
            dp[0] = true;
            
            for(int i = 1; i <= n; i++){
                for(int j = (i==n? 1 : 0); !dp[i] && j < i; j++){
                    String suffix = word.substring(j, i);
                    dp[i] = dp[j] && set.contains(suffix);
                }
            }
            if(dp[n])
                res.add(word);
        }
        
        return res;
    }
}