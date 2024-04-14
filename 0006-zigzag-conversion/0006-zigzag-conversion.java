class Solution {
    public String convert(String s, int numRows) {
        if(numRows >= s.length())
            return s;
        
        Map<Integer, List<Character>> rows = new HashMap<>();
        int count = 0;
        int v = 1;
        for(char c: s.toCharArray()){
            rows.computeIfAbsent(count, k -> new ArrayList<>()).add(c);
            count+=v;
            count%=numRows;
            if(count==numRows-1 || count==0)
                v = -v;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int rowNo: rows.keySet()){
            for(char c: rows.get(rowNo))
                sb.append(c);
        }
        return sb.toString();
    }
}