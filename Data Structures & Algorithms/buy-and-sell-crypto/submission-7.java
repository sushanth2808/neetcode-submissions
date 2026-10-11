class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        for(int i=1;i<prices.length;i++){
            int sell= prices[i];
            maxProfit = Math.max(maxProfit,sell-buy);
            if(sell-buy<=0){
                buy = sell;
            }
        }
        return maxProfit;
    }

}
