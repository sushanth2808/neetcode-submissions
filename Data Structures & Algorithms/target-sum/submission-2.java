class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total =0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }

        int[][] dp = new int[nums.length][total*2+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return findways(nums,target+total,0,total,dp);
       
    }

    private int findways(int[] nums,int target,int i,int sum,int[][] dp){
        if(i==nums.length){
            if(sum==target){
                return 1;
            }
            return 0;
        }
if(sum < 0 || sum >= dp[0].length){
    return 0;
}
        if(dp[i][sum]!=-1){return dp[i][sum];}
        dp[i][sum] = findways(nums,target,i+1,sum+nums[i],dp)+findways(nums,target,i+1,sum-nums[i],dp);
        return dp[i][sum];
    }
}
