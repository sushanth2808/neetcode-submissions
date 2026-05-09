class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = prices[n-1];
        int res=0;
        for(int i=n-2;i>=0;i--){
            res=Math.max(res,max-prices[i]);
            max=Math.max(max,prices[i]);
        }
        return res;
    }
}
