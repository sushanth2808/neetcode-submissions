class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] res=new int[1];
        findways(nums,target,0,0,res);
        return res[0];
    }

    private void findways(int[] nums,int target,int i,int sum, int[] res){
        if(i==nums.length){
            if(sum==target){
            res[0]++;
            }
            return;
        }
        findways(nums,target,i+1,sum+nums[i],res);
        findways(nums,target,i+1,sum-nums[i],res);
    }
}
