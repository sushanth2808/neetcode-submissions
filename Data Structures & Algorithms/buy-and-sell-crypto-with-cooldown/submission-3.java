class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return buySell(prices,0,0,dp);
        
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
