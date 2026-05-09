class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][prices.length+1];
        for(int i=0;i<prices.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return buySell(prices,0,-1,dp);
        
    }

    private int buySell(int[] prices,int idx,int bought,int[][] dp){
        if(idx>=prices.length){
            return 0;
        }
        if(dp[idx][bought+1]!=-1){return dp[idx][bought+1];}
        if(bought!=-1){
           return dp[idx][bought+1]= Math.max((prices[idx]-prices[bought])+buySell(prices,idx+2,-1,dp), buySell(prices,idx+1,bought,dp));
        }
        else{
            return dp[idx][bought+1] = Math.max(buySell(prices,idx+1,idx,dp),buySell(prices,idx+1,-1,dp)); 
        }
        
    }
}
