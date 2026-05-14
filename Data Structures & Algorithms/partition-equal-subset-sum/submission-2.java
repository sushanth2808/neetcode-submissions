class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1){return false;}
        return findPart(nums,sum/2,0);
        
    }

    private boolean findPart(int[] nums, int sum,int index){
        if(sum==0){
            return true;
        }
        if(index==nums.length){
            return false;
        }

        return findPart(nums,sum-nums[index],index+1) || findPart(nums,sum,index+1);
    }
}
