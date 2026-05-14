class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1){return false;}
        int half = sum/2;
        Boolean[][] dp = new Boolean[nums.length][half+1];
        return findPart(nums,half,0,dp);
        
    }

    private boolean findPart(int[] nums, int sum,int index,Boolean[][] dp){
        if(sum==0){
            return true;
        }
        if(sum<0 || index==nums.length){
            return false;
        }
        if(dp[index][sum]!=null) return dp[index][sum];
        return dp[index][sum]=findPart(nums,sum-nums[index],index+1,dp)||findPart(nums,sum,index+1,dp);
        
    }
}
