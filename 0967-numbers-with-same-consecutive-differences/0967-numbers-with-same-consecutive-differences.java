class Solution {
    List<String> res = new ArrayList();
    int n, k;
    public int[] numsSameConsecDiff(int n, int k) {
        this.n = n;
        this.k = k;
        for(int i = 1; i < 10; i++){
            StringBuilder init = new StringBuilder();
            init.append(i);
            backtrack(i, init);
        }
        int[] ans = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            int num = Integer.parseInt(res.get(i));
            ans[i] = num;
        }
        return ans;
    }
    public void backtrack(int i, StringBuilder curr){
        if(curr.length()==n){
            res.add(curr.toString());
            return;
        }
        
        int f = i+k;
        int b = i-k;
        
        if(0 <= f && f < 10){
            curr.append(f);
            backtrack(f, curr);
            curr.deleteCharAt(curr.length()-1);
        }
        
        if(f!=b && 0 <= b && b < 10){
            curr.append(b);
            backtrack(b, curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}