class Solution {
    int minCount =Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,-2);
        return find(coins,amount,0,dp);
    }

    private int find(int[] coins, int amount, int index,int[] dp){
        if(amount==0){return 0;}
        if(amount<0){
            return -1;
        }
        if(dp[amount]!=-2){return dp[amount];}
        int count =Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            int res = find(coins,amount-coins[i],i,dp);
            if(res>=0){
                count =Math.min(count,1+find(coins,amount-coins[i],i,dp));
            }
        }
        return dp[amount]= count==Integer.MAX_VALUE?-1:count;
    }
}
