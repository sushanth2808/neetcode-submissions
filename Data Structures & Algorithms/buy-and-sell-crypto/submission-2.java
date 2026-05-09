class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] rightarr= new int[n];
        rightarr[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            rightarr[i]=Math.max(prices[i+1],rightarr[i+1]);
        }
        int res =0;
        for(int i=0;i<n;i++){
            res=Math.max(res,rightarr[i]-prices[i]);
        }
        return res;

    }
}
