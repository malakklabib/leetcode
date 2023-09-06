class Solution {
    public boolean checkIfPangram(String sentence) {
        char[] alph = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                                    'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Set<Character> charSet = new HashSet<Character>();
        for(char c : sentence.toCharArray())
            charSet.add(c);
        for(char c : alph){
            if(!charSet.contains(c))
                return false;
        }
        return true;
    }
}