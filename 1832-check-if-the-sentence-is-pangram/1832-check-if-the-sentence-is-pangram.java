class Solution {
    public boolean checkIfPangram(String sentence) {
        char[] alph = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                                    'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for(char c : alph)
            if(sentence.indexOf(c) == -1)
                return false;
        return true;
    }
}