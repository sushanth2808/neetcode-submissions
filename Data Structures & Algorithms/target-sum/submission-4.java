class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total =0;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
                if(Math.abs(target) > total) {
            return 0;
        }
        int[][] dp = new int[n+1][total*2+1];
        dp[n][total]=1;
        int sum=total*2;
        for(int i=n-1;i>=0;i--){
            for(int j=sum;j>=0;j--){
                if(j+nums[i]<=sum)
                    dp[i][j]=dp[i+1][j+nums[i]];
                if(j-nums[i]>=0){
                    dp[i][j]=dp[i][j]+dp[i+1][j-nums[i]];
                }
            }
        }
        return dp[0][target+total];

        // int[][] dp = new int[nums.length][total*2+1];
        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // return findways(nums,target+total,0,total,dp);
       
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
