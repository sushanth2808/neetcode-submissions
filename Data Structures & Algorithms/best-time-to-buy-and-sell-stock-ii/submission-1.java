class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
       return maxP(prices,0,0,dp);
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