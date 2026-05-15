class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for(int i=0;i<n;i++){
            total+=nums[i];
        }
        if(Math.abs(target)>total){return 0;}
        if((target+total)%2!=0)return 0;

        int sum = (total+target)/2;
        int[][] dp = new int[n+1][sum+1];
        dp[n][0]=1;
        for(int i=n-1;i>=0;i--){
            for(int j=sum;j>=0;j--){
                int skip=dp[i+1][j];
                int take=0;
                if(j>=nums[i]){
                    take=dp[i+1][j-nums[i]];
                }
                dp[i][j]=skip+take;
            }
        }
        return dp[0][sum];
    }

    private int find(int[] nums,int sum,int[][] dp,int index){

        if(index==nums.length || sum<0){
            if(sum==0){
            return 1;
            }
            return 0;
        }
        
        if(dp[index][sum]!=-1){return dp[index][sum];}

        dp[index][sum] = find(nums,sum-nums[index],dp,index+1)+find(nums,sum,dp,index+1);
        return dp[index][sum];
    }
}
