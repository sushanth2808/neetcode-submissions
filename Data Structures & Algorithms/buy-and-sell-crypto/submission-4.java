class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }

        int maximum = 0;
        int buy = prices[0];
        for(int i=1;i<prices.length;i++){
            int profit = prices[i]-buy;
            maximum = Math.max(maximum, profit);
            buy = Math.min(buy,prices[i]);
        }
        return maximum;
    }
}
