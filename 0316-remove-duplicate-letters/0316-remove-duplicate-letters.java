class Solution {
    public String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        
        for(char c: s.toCharArray())
            counts[c-'a']++;
        
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[26];
        
        for(char c: s.toCharArray()){
            counts[c-'a']--;
            
            if(inStack[c-'a'])
                continue;
            
            while(!stack.isEmpty() && counts[stack.peek()-'a'] > 0 && c <= stack.peek())
                inStack[stack.pop()-'a'] = false;
                
            stack.push(c);
            inStack[c-'a'] = true;
        }
        
        StringBuilder res = new StringBuilder();
        
        while(!stack.isEmpty())
            res.append(stack.pop());
        
        return res.reverse().toString();
    }
}