class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        return findCost(cost,n,dp);
    }

    private int findCost(int[] cost,int index,int[] dp){
        if(index==0 || index==1) return 0;
        if(dp[index]!=0)return dp[index];
        dp[index]=Math.min(findCost(cost,index-1,dp)+cost[index-1],
                                findCost(cost,index-2,dp)+cost[index-2]);
        return dp[index];
    }
}
