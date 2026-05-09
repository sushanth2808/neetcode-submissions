class Solution {
   public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest=0;
        int curr=0;
        for(int i=0;i<n;i++){
            if(curr>=n-1){return true;}
            farthest = Math.max(farthest,i+nums[i]);
            if(curr==i){
                curr=farthest;
            }  
        }
        return false;
    }
}
