class Solution {
    public int compress(char[] chars) {
        int lastGroupIndex = 0;
        int firstOccurrenceIndex = 0;
        for(int i = 0; i < chars.length; i++){
            if(i==chars.length-1 || chars[i] != chars[i+1]){
                int runLen = i-firstOccurrenceIndex+1;
                chars[lastGroupIndex++] = chars[firstOccurrenceIndex];
                
                if(runLen > 1){
                    for(char c: String.valueOf(runLen).toCharArray())
                        chars[lastGroupIndex++] = c;
                }
                
                firstOccurrenceIndex = i+1;
            }
        }
        return lastGroupIndex;
    }
}