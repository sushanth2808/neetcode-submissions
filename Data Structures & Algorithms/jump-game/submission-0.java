class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        return jump(nums,n,0);
    }

    private boolean jump(int[] nums, int n , int idx){
        if(idx>=n-1){
            return true;   
        }
        if(nums[idx]==0){
            return false;
        }
        for(int i=nums[idx];i>0;i--){
            if(jump(nums,n,i+idx)){
                return true;   
            }
        }
        return false;
    }
}
