class Solution {
    Map<Character, String> map = Map.of(
    '2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    List<String> res = new ArrayList();
    int n;
    String digits;
    
    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        n = digits.length();
        backtrack(0, new StringBuilder());
        return res;
    }
    
    public void backtrack(int i, StringBuilder curr){
        if(i == n){
            if(!curr.isEmpty())
                res.add(curr.toString());
            return;
        }
        
        for(char c: map.get(digits.charAt(i)).toCharArray()){
            curr.append(c);
            backtrack(i+1, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}