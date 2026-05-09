class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)return false;
        Boolean[][] dp = new Boolean[nums.length][sum/2+1];
        return find(nums,sum/2,0,dp);
    }

    private boolean find(int[] nums, int sum , int index,Boolean[][] dp){
        if(sum==0){
            return true;
        }
        if(index==nums.length || sum<0){
            return false;
        }
        if(dp[index][sum]!=null)return dp[index][sum];

        dp[index][sum] = find(nums,sum-nums[index],index+1,dp);
        if(dp[index][sum])return true;
        dp[index][sum] = find(nums,sum,index+1,dp);
        return dp[index][sum];
    }
}
