class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length()>magazine.length())
            return false;
        char[] r = ransomNote.toCharArray();        
        char[] m = magazine.toCharArray();
        Arrays.sort(r);
        Arrays.sort(m);
        int i=0, j=0;
        while(i < r.length && j < m.length){
            if(r[i] < m[j])
                return false;
            else if(r[i] > m[j])
                j++;
            else{
                j++;
                i++;
            }
        }
        return i==r.length;
    }
}