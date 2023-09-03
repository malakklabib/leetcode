class Solution {
    public String reverseWords(String s) {
        int a = 0, b = 0;
        char tmp;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i));
            if(s.charAt(i) == ' ' || i == s.length()-1){
                b = i-1;
                if(i == s.length()-1)
                    b++;
                while(a < b){
                    tmp = s.charAt(a);
                    sb.setCharAt(a, s.charAt(b));
                    sb.setCharAt(b, tmp);
                    a++;
                    b--;
                }
                a = i + 1;
            }
            
        }
        
        return sb.toString();
    }
}