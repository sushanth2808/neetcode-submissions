class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            int j=i;
            while(nums[j]>0 && nums[j]<n && nums[nums[j]-1]!=nums[j] ){
                int temp = nums[nums[j]-1];
                nums[nums[j]-1]=nums[j];
                nums[j]=temp;
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }
}