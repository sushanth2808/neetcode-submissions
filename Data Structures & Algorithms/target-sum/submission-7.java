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



        int[][] dp = new int[n][sum+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(nums,sum,dp,0);
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
