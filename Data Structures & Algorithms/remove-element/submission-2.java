class Solution {
    public int removeElement(int[] nums, int val) {
        int n =nums.length;
        int right=n-1;

        while(right>=0 && nums[right]==val){
            right--;
        }
        for(int left=0;left<=right;left++){
            if(nums[left]==val){
                int temp = nums[right];
                nums[right]=nums[left];
                nums[left]=temp;
                right--;
            }
        while(right>=0 && nums[right]==val){
            right--;
        }
        }
        return right+1;
    }
}