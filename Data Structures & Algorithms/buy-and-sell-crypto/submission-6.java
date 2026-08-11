class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n<=1){
            return 0;
        }
        int res = 0;
        int maxbuy = prices[0];
        for(int i=1;i<n;i++){
            if(prices[i]<=maxbuy){
                maxbuy = prices[i];
            }
            else{
                res = Math.max(res,prices[i]-maxbuy);
            }
        }
        return res;
    }
}
