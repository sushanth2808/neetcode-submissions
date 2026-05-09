class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        if(n==1)return 0;
        return jumps(nums,n,0,dp);
    }

    private int jumps(int[] nums, int n , int idx,int[] dp){

        if(dp[idx]!=-1) return dp[idx];
        int count =Integer.MAX_VALUE;
        for(int i=nums[idx];i>0;i--){
            int res = 0;
            if(i+idx<n-1){
                if(nums[i+idx]==0){
                    continue;
                }
                res = 1+jumps(nums,n,i+idx,dp);
                count = Math.min(count,res);
            }else{
                count = Math.min(count,1);
               break;
            }  
        }
        
        return dp[idx]=count;
    }
}
