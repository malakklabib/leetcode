class Solution {
    public int firstUniqChar(String s) {
        boolean flag;
        for(int i=0;i<s.length();i++){
            flag = false;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && i!=j){
                    flag=true;
                    break;
                }
            }
            if(!flag)
                return i;
            
        }
        return -1;
    }
}