class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return jump(nums,n,0,dp);
    }

    private boolean jump(int[] nums, int n , int idx,Boolean[] dp){
        if(idx>=n-1){
            return true;   
        }
        if(nums[idx]==0){
            return false;
        }
        if(dp[idx]!=null) return dp[idx];
        for(int i=nums[idx];i>0;i--){
            if(jump(nums,n,i+idx,dp)){
                return true;   
            }
        }
        return dp[idx]=false;
    }
}
