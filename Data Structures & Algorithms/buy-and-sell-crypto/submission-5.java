class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<=1){
            return 0;
        }

        int maximum = 0;
        int buy=0;
        int sell=1;
        while(sell<prices.length){
            int profit = prices[sell]-prices[buy];
            maximum = Math.max(maximum,profit);
            if(profit<0){
                buy=sell;
                sell++;
            }
            else{
                sell++;
            }
        }
        return maximum;
    }
}
