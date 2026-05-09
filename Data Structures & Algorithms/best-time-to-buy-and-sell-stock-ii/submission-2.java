class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[n-1][0]=0;
        dp[n-1][1]=prices[n-1];
        for(int i=n-2;i>=0;i--){
            dp[i][0]=Math.max(-prices[i]+dp[i+1][1],dp[i+1][0]);
            dp[i][1]=Math.max(prices[i]+dp[i+1][0],dp[i+1][1]);
        }
       return dp[0][0];
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