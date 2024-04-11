class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        candies[0] = 1;
        
        for(int i = 1; i < n; i++){
            if(ratings[i-1] < ratings[i])
                candies[i] = 1 + candies[i-1];
            else
                candies[i] = 1;
        }// 1 2 3 4 1
        
        for(int i = n-2; i >= 0; i--){
            if(ratings[i+1] < ratings[i]){
                if(candies[i+1] >= candies[i])
                    candies[i] = 1 + candies[i+1];
            }
            System.out.println(candies[i]);
        }
        
        int sum = 0;
        for(int candy: candies)
            sum+=candy;
        return sum;
    }
}