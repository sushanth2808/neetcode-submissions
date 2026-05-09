class Solution {
    public int findMin(int[] nums) {
        int n =nums.length;
        int p1=0;
        int p2=n-1;
        while(p1<p2){
            int mid = p1+(p2-p1)/2;
            if(nums[mid]<nums[p2]){
                p2=mid;
               
            }
            else{
                 p1=mid+1;
            }
        }
        return nums[p1];
    }
}
