class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack();
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")){
                int op2 = s.pop();
                int op1 = s.pop();
                switch(token){
                    case "+": s.push(op1+op2); break;
                    case "-": s.push(op1-op2); break;
                    case "/" : s.push(op1/op2); break;
                    default: s.push(op1*op2); break;
                }
            }
            else
                s.push(Integer.parseInt(token));
        }
        return s.pop();
    }
}