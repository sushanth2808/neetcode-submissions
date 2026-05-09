class Solution {
    int maxCount = 0;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return findlis(nums,-1,n,dp)-1;
    }

    private int findlis(int[] nums, int index, int n,int[] dp){
        if(index==n-1){
            return 1;
        }
        if(index!=-1 && dp[index]!=-1){return dp[index];}
        int maxCount = 1;
        for(int i=index+1;i<n;i++){
            int count = 1;
            if(index==-1 || nums[index]<nums[i]){  
                count=count+findlis(nums,i,n,dp);
                maxCount = Math.max(count,maxCount);
            }
        }
        //maxCount = Math.max(count,maxCount);
        return index!=-1?dp[index]=maxCount:maxCount;
    }
}
