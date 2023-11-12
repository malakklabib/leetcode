class Solution {
    public int maximum69Number (int num) {
        String s = "" + num;
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='6'){
                sb.deleteCharAt(i);
                sb.insert(i, "9");
                break;
            }
        }
        return Integer.parseInt(sb.toString());
    }
}