class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        Arrays.fill(dp,-1);
        return 0+robbery(nums,n+1,dp);
    }

    private int robbery(int[] nums,int i,int[] dp){
        if(i==0 || i==1) return 0;
        if(i==2) return nums[0];
        if(dp[i]!=-1)return dp[i];
        dp[i] = Math.max(robbery(nums,i-2,dp)+nums[i-2],robbery(nums,i-3,dp)+nums[i-3]);
        return dp[i];
    }

}
