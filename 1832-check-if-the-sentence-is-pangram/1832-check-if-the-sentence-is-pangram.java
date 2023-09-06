class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> alph = Set.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
                                    'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        Set<Character> charSet = sentence.chars().mapToObj(c ->(char)c).collect(Collectors.toSet());
        for(Character c : alph){
            if(!charSet.contains(c))
                return false;
        }
        return true;
    }
}