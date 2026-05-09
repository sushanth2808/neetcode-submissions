class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+2][2];
        for(int i=prices.length-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                if(j==1){
                    dp[i][j]=Math.max(prices[i]+dp[i+2][0],dp[i+1][1]);
                }
                else{
                    dp[i][j]=Math.max(-prices[i]+dp[i+1][1],dp[i+1][0]);
                }
            }
        }
        return dp[0][0];
        
    }

    private int buySell(int[] prices,int idx,int bought,int[][] dp){
        if(idx>=prices.length){
            return 0;
        }
        if(dp[idx][bought]!=-1){return dp[idx][bought];}
        if(bought==1){
           return dp[idx][bought]= Math.max(prices[idx]+buySell(prices,idx+2,0,dp), buySell(prices,idx+1,1,dp));
        }
        else{
            return dp[idx][bought] = Math.max(-prices[idx]+buySell(prices,idx+1,1,dp),buySell(prices,idx+1,0,dp)); 
        }
        
    }
}
