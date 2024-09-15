class Solution {
    public int expressiveWords(String s, String[] words) {
        s = decode(s);
        
        for(int i = 0; i < words.length; i++)
            words[i] = decode(words[i]);
        
        int count = 0;
        for(String word: words){
            if(s.length() == word.length() && isStretchy(s, word))
                count++;
        }
        return count;
    }
    
    private String decode(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int count = 1;
            while(i < s.length()-1 && s.charAt(i)==s.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    
    private boolean isStretchy(String s, String word){
        for(int i = 0; i < word.length(); i+=2){
            if((word.charAt(i) == s.charAt(i) || (s.charAt(i) > word.charAt(i) && s.charAt(i) >= '3'))
              && word.charAt(i+1) == s.charAt(i+1))
                continue;
            else
                return false;
        }
        return true;
    }
}