class Solution {
    public String removeStars(String s) {
        Stack<Character> t = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='*')
                t.pop();
            else
                t.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c: t)
            sb.append(c);
        return sb.toString();
    }
}