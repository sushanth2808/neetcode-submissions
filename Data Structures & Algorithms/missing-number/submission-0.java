class Solution {
    public int missingNumber(int[] nums) {
        int res=0;
        for(int i=1;i<nums.length+1;i++){
           res = res^nums[i-1]^i;
        }
        return res;
    }
}
