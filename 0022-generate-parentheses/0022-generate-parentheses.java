class Solution {
    List<String> res = new ArrayList();
    int n;
    
    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtrack(0,0,new StringBuilder());
        return res;
    }
    
    public void backtrack(int open, int close, StringBuilder curr){
        if(curr.length()==n*2){
            res.add(curr.toString());
            return;
        }
        
        if(open < n){
            curr.append("(");
            backtrack(open+1,close,curr);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close < open){
            curr.append(")");
            backtrack(open,close+1,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}