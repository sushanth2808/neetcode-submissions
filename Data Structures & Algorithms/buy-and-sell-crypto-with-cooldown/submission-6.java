class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+2][2];
        int notholding2=0;
        int holding1=0;
        int notholding1=0;
        int currholding=0;
        int currnotholding=0;
        for(int i=prices.length-1;i>=0;i--){
            for(int j=1;j>=0;j--){
                if(j==1){
                    currholding=Math.max(prices[i]+notholding2,holding1);
                }
                else{
                    currnotholding=Math.max(-prices[i]+holding1,notholding1);
                }
            }
            notholding2=notholding1;
            notholding1=currnotholding;
            holding1= currholding;
        }
         return currnotholding;
        
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
