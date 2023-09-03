class Solution {
    public String reverseOnlyLetters(String s) {
        int a = 0, b = s.length()-1;
        StringBuilder sb = new StringBuilder();
        char tmp;
        for(int i = 0; i < s.length(); i++)
            sb.append(s.charAt(i));
        while(a < b){
            if((s.charAt(a) >='a' && s.charAt(a) <= 'z') || (s.charAt(a) >= 'A' && s.charAt(a) <= 'Z')){
                if((s.charAt(b) >='a' && s.charAt(b) <= 'z') || (s.charAt(b) >= 'A' && s.charAt(b) <= 'Z')){
                    tmp = s.charAt(a);
                    sb.setCharAt(a, s.charAt(b));
                    sb.setCharAt(b, tmp);
                    a++;
                    b--;
                }
                else
                    b--;
            }
            else
                a++;
        }
        return sb.toString();
    }
}