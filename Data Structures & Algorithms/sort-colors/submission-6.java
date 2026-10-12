class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = low;
        while(mid<=high){
            if(nums[mid]==0){
                swap(mid,low,nums);
                low++;
                mid++;
            }
            else if(nums[mid]==2){
                swap(mid,high,nums);
                high--;  
            }
            else{
                mid++;
            }
        }
    }

    private void swap(int p1 ,int p2, int[] nums){
        int temp = nums[p1];
        nums[p1]=nums[p2];
        nums[p2]=temp;
    }
}