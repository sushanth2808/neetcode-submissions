class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1){return false;}
        int half = sum/2;
        int n = nums.length;
        Boolean[] dp = new Boolean[half+1];
        dp[0]=true;
        for(int i=1;i<=half;i++){
            dp[i]=false;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=half;j>=0;j--){
                if(j>=nums[i]){
                    dp[j]=dp[j] || dp[j-nums[i]];
                }else{
                    dp[j]=dp[j];
                }
            }
        }
        return dp[half];
        
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
