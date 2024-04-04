class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int profit = 0;
        while(r < prices.length) {
            if(prices[l]>=prices[r])
                l = r;
            else
                profit = Math.max(profit, prices[r]-prices[l]);
            r++;
        }
        return profit;
    }
}