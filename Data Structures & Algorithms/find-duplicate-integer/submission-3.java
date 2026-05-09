class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i]);
            if(nums[val]<0){
                return Math.abs(nums[i]);
            }
            nums[val]*=-1;
        }
        return -1;
    }
}
