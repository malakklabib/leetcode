class Solution {
    public String makeGood(String s) {
        Stack<Character> t = new Stack<>();
        for(char c: s.toCharArray()){
            if(!t.isEmpty() && ((Character.isLowerCase(c) && t.peek()==Character.toUpperCase(c)) || (Character.isUpperCase(c) && t.peek()==Character.toLowerCase(c))))
                t.pop();
            else
                t.push(c);
        }
        
        if(t.isEmpty())
            return "";
        
        StringBuilder sb = new StringBuilder();
        for(Character c: t)
            sb.append(c);
        return sb.toString();
    }
}