class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        int p = 0;
        for(int i = 0; i < pushed.length; i++){
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek() == popped[p]){
                s.pop();
                p++;
            }
        }
        while(p < popped.length){
            if(s.peek() == popped[p]){
                s.pop();
                p++;
            }
            else
                return false;
        }
        return true;
    }
}