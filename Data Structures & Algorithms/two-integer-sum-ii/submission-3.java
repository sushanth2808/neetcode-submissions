class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0;i<numbers.length;i++){
            int sum = target-numbers[i];
            int index1=i+1;
            int index2=binarySearch(i+1,numbers.length-1,numbers,sum)+1;
            if(index2!=0){
                return new int[]{index1,index2};
            }
        }
        return new int[0];
    }

    private int binarySearch(int l, int r,int[] nums,int target){
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}
