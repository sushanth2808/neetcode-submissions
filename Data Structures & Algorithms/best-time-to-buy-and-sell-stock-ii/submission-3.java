class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        int prevNotHolding=0;
        int prevHolding=prices[n-1];
        for(int i=n-2;i>=0;i--){
            int currNotHolding=Math.max(-prices[i]+prevHolding,prevNotHolding);
            int currHolding=Math.max(prices[i]+prevNotHolding,prevHolding);
            prevNotHolding=currNotHolding;
            prevHolding=currHolding;
        }
       return prevNotHolding;
    }

    private int maxP(int[] prices,int index,int buy,int[][] dp){
        if(index==prices.length){
            return 0;
        }
        if(dp[index][buy]!=-1){return dp[index][buy];}
        if(buy==1){
            return dp[index][buy]= Math.max(prices[index]+maxP(prices,index+1,0,dp), maxP(prices,index+1,1,dp));
        }
       return dp[index][buy]= Math.max(-prices[index]+maxP(prices,index+1,1,dp),maxP(prices,index+1,0,dp)); 
    }
}