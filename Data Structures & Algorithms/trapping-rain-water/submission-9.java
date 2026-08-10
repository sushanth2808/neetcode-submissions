class Solution {
    public int trap(int[] height) {
        int[] nums = height;
        int p1 = 0;
        int p2=nums.length-1;

        int left = nums[p1];
        int right = nums[p2];
        int res =0;
        while(p1<p2){
            if(nums[p1]<=nums[p2]){
                if(nums[p1]<left){
                    res=res+(left-nums[p1]);
                }
                else{
                    left=nums[p1];
                }
                p1+=1;
            }
            else{
                if(nums[p2]<right){
                    res=res+(right-nums[p2]);
                }
                else{
                    right=nums[p2];
                }
                p2-=1;
            }
        }
        return res;
    }
}
