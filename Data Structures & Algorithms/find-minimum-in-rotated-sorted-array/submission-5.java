class Solution {
    public int findMin(int[] nums) {

        int p1 = 0;
        int p2=nums.length-1;
        int res = Integer.MAX_VALUE;
        while(p1<p2){
            int mid = p1+(p2-p1)/2;
            if(nums[mid]>nums[p2]){
                p1=mid+1;
            }
            else{
                p2=mid;
            }
        }
        return nums[p2];
    }
}
