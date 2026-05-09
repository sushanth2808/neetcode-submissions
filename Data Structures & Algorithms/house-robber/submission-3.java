class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n==1){
            return nums[0];
        }
        dp[0]=nums[0];
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[n-1];
    }

    private int robbery(int[] nums,int i,int[] dp){
        if(i<0)return 0;
        if(dp[i]!=-1)return dp[i];
        dp[i] = Math.max(robbery(nums,i-1,dp),nums[i]+robbery(nums,i-2,dp));
        return dp[i];
    }

}
