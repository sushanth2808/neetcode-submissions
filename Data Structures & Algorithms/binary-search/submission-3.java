class Solution {
    public int search(int[] nums, int target) {
        Arrays.sort(nums);
        int p1 = 0;
        int p2 = nums.length-1;
        int ans = -1;
        while(p1<=p2){
            int mid = p1+((p2-p1)/2);
            if(nums[mid]>=target){
                ans = mid;
                p2=mid-1;
            }
            else{
                p1=mid+1;
            }
        }
        if(ans!=-1 && nums[ans]==target){
            return ans;
        }
        return -1;
    }
}
