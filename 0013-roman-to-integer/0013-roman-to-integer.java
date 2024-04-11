class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        int ans = 0;
        
        if(n==1)
            return dec(s);
        
        int res = 0;
        for(int i = 0; i < n; i++){
            if(i < n-1 && sub(s.charAt(i),s.charAt(i+1))){
                res += dec(String.valueOf(s.charAt(i+1))) - dec(String.valueOf(s.charAt(i)));
                i++;
            }
            else
                res += dec(String.valueOf(s.charAt(i)));
        }
        return res;
    }
    
    public int dec(String s){
        switch(s){
            case "I": return 1;
            case "V": return 5; 
            case "X": return 10;
            case "L": return 50;
            case "C": return 100; 
            case "D": return 500; 
            case "M": return 1000;
            default: return 0;
        }
    }
    
    public boolean sub(char c, char x){
        return c=='I' && (x=='V' || x=='X') ||
            c=='X' && (x=='L' || x=='C') ||
            c=='C' && (x=='D' || x=='M');
    }
}