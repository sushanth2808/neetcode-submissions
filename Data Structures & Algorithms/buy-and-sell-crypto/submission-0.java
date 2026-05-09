class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mp = 0;
        int buy = prices[0];
        for(int i=1;i<n;i++){
            int profit = prices[i]-buy;
            if(mp<profit){
                mp = profit;
            }
            if(profit<0){
                buy=prices[i];
            }
        }
        return mp;
    }
}
