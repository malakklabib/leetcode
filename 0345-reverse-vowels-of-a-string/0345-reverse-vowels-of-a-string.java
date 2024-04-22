class Solution {
    Set<Character> vowels = new HashSet(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            if(vowels.contains(c))
                sb.append(c);
        }
        sb.reverse();
        String v = sb.toString();
        int i = 0;
        StringBuilder res = new StringBuilder();
        for(char c: s.toCharArray()){
            if(vowels.contains(c))
                res.append(v.charAt(i++));
            else
                res.append(c);
        }
        return res.toString();
    }
}