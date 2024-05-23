class Solution {
    String s;
    List<List<String>> res = new ArrayList();
    public List<List<String>> partition(String s) {
        this.s = s;
        backtrack(0, new ArrayList());
        return res;
    }
    public void backtrack(int i, List<String> curr){
        if(i==s.length()){
            res.add(new ArrayList(curr));
            return;
        }
        
        for(int j = i+1; j <= s.length(); j++){
            String str = s.substring(i,j);
            if(isPalindrome(str)){
                curr.add(str);
                backtrack(j, curr);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}