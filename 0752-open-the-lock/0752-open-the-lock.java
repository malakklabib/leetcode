class State{
    String code;
    int turns;
    public State(String code, int turns) {
        this.code = code;
        this.turns = turns;
    }
}

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> seen = new HashSet<>();
        for(String d: deadends)
            seen.add(d);
        if(seen.contains("0000"))
            return -1;
        
        Queue<State> queue = new LinkedList<>();
        queue.add(new State("0000", 0));
        
        while(!queue.isEmpty()) {
            State state = queue.remove();
            String code = state.code;
            int turns = state.turns;
            if(code.equals(target))
                return turns;
            String[] nums = code.split("");
            for(int i = 0; i < 4; i++) {
                int num = Integer.parseInt(nums[i]);
                
                nums[i] = String.valueOf((num-1+10)%10);
                String newCode1 = String.join("", nums);
                nums[i] = String.valueOf((num+1)%10);
                String newCode2 = String.join("", nums);
                nums[i] = String.valueOf(num);
                
                if(!seen.contains(newCode1)){
                    seen.add(newCode1);
                    queue.add(new State(newCode1, turns+1));
                }
                if(!seen.contains(newCode2)){
                    seen.add(newCode2);
                    queue.add(new State(newCode2, turns+1));
                }
            }
        }
        return -1;
    }
}