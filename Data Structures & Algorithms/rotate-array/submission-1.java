class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        int p1=0;
        int p2=nums.length-1;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    private void reverse(int[] nums, int p1,int p2){
        while(p1<p2){
            int temp = nums[p1];
            nums[p1]=nums[p2];
            nums[p2]=temp;
            p1++;
            p2--;
        }
    }
}