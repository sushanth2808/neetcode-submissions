class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }

        if(sum%2!=0)return false;
        return find(nums,sum/2,0);
    }

    private boolean find(int[] nums, int sum , int index){
        if(sum==0){
            return true;
        }
        if(index==nums.length || sum<0){
            return false;
        }
        if(find(nums,sum-nums[index],index+1))return true;
        return find(nums,sum,index+1);
    }
}
