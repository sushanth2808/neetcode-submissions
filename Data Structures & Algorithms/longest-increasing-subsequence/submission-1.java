class Solution {
    int maxCount = 0;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if(n==1){return 1;}
        Arrays.fill(dp,-1);
        return findlis(nums,-1,n,dp);
    }

    private int findlis(int[] nums, int index, int n,int[] dp){
        if(index==n-1){
            return 0;
        }
        if(index!=-1 && dp[index]!=-1){return dp[index];}
        int count = 0;
        for(int i=index+1;i<n;i++){
            if(index==-1 || nums[index]<nums[i]){  
                int res=1+findlis(nums,i,n,dp);
                count = Math.max(res,count);
            }
        }
        //maxCount = Math.max(count,maxCount);
        return index!=-1?dp[index]=count:count;
    }
}
