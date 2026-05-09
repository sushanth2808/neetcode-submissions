class Solution {
    public int search(int[] nums, int target) {
        int n =nums.length;
        int p1=0;
        int p2=n-1;
        while(p1<=p2){
            int mid = (p1+p2)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<=nums[p2]){
                if(target<nums[mid] || target>nums[p2]){
                    p2=mid-1;
                }
                else{
                    p1=mid+1;
                }
            }
            else{
                if(target>nums[mid] || target<nums[p1]){
                    p1=mid+1;
                } 
                else{
                    p2=mid-1;
                }
            }
        }
        return -1;
    }
}
