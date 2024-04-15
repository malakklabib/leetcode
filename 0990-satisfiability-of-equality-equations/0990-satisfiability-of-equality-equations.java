class Solution {
    Map<Character,List<Character>> eq = new HashMap();
    Map<Character,List<Character>> neq = new HashMap();
    public boolean equationsPossible(String[] equations) {
        for(String equation : equations){
            char sign = equation.charAt(1);
            char op1 = equation.charAt(0);
            char op2 = equation.charAt(3);
            if(op1==op2 && sign=='!')
                return false;
            if(sign=='='){
                if(!eq.containsKey(op1))
                    eq.put(op1, new ArrayList());
                if(!eq.containsKey(op2))
                    eq.put(op2, new ArrayList());
                eq.get(op1).add(op2);
                eq.get(op2).add(op1);
            }
            else{
                if(!neq.containsKey(op1))
                    neq.put(op1, new ArrayList());
                if(!neq.containsKey(op2))
                    neq.put(op2, new ArrayList());
                neq.get(op1).add(op2);
                neq.get(op2).add(op1);
            }
        }
        
        for(char key : eq.keySet()){
            Set<Character> seen = new HashSet();
            dfs(key, seen);
            for(char seenNode : seen){
                if(neq.containsKey(seenNode) && neq.get(seenNode).contains(key))
                    return false;
            }
        }
        return true;
    }
    public void dfs(char node, Set<Character> seen){
        for(char neighbor : eq.get(node)){
            if(!seen.contains(neighbor)){
                seen.add(neighbor);
                dfs(neighbor, seen);
            }
        }
    }
}