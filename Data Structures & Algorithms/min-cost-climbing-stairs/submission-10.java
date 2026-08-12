class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        int step1=cost[0];
        int step2=cost[1];
        for(int i=2;i<n;i++){
            int temp=cost[i]+Math.min(step1,step2);
            step1=step2;
            step2=temp;
        }
        return Math.min(step2,step1);
    }
}
