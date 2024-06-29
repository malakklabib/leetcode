class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack();
        int[] res = new int[temperatures.length];
        s.push(0);
        
        for(int i = 1; i < temperatures.length; i++){
            int t = temperatures[i];
            if(!s.isEmpty() && temperatures[s.peek()] >= t)
                s.push(i);
            
            while(!s.isEmpty() && temperatures[s.peek()] < t){
                res[s.peek()] = i-s.pop();
            }
            s.push(i);
        }
        return res;
    }
}