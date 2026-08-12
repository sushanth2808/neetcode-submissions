class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[n-1]=findCost(cost,n-1,dp);
        dp[n-2]=findCost(cost,n-2,dp);
        return Math.min(dp[n-1],dp[n-2]);
    }

    private int findCost(int[] cost, int idx,int[] dp){
        if(idx==0|| idx==1){return cost[idx];}

        if(dp[idx]!=-1){return dp[idx];}
        dp[idx]= cost[idx]+Math.min(findCost(cost,idx-1,dp),findCost(cost,idx-2,dp));
        return dp[idx];

    }
}
