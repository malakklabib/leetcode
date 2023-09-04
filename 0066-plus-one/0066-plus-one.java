class Solution {
    public int[] plusOne(int[] digits) {
        
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            if(digits[i]==10)
                digits[i]=0;
            else
                break;
            
        }
        
        int[] result;
        
        if(digits[0]==0){
            
            result=new int[digits.length+1];
             for(int i=digits.length-1;i>0;i--)
                 result[i+1]=digits[i];
            result[0]=1;
        }
        else{
            result=new int[digits.length];
            for(int i=digits.length-1;i>=0;i--)
                 result[i]=digits[i];
        }
        return result;
    }
}