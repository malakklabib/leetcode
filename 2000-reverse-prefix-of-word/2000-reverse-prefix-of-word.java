class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder(word);
        int ind = 0;
        String s = "";
        for(int i = 0; i < word.length(); i++){
            sb.append(word.charAt(i));
            if(word.charAt(i) == ch){
                ind = i+1;
                s = sb.reverse().toString();
                break;
            }
        }
        if(!s.equals(""))
            ans.replace(0, ind, s);
        return ans.toString();
    }
}