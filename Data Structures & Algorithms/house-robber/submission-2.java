class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return robbery(nums,n-1,dp);
    }

    private int robbery(int[] nums,int i,int[] dp){
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        dp[i] = Math.max(robbery(nums,i-1,dp),nums[i]+robbery(nums,i-2,dp));
        return dp[i];
    }

}
