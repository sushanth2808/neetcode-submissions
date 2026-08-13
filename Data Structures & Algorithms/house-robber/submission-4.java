class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int n = nums.length;
        Arrays.fill(dp,-1);
       return houserob(nums,n-1,dp);
    }


   private int houserob(int[] nums, int index,int[] dp){
        if(index<0)return 0;
        if(dp[index]!=-1){return dp[index];}
        dp[index]=Math.max(houserob(nums,index-1,dp),houserob(nums,index-2,dp)+nums[index]);
        return dp[index];
    }
}
