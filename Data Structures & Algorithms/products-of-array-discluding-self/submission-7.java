class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length];
        arr[0]=1;
        for(int i=1;i<n;i++){
            arr[i]=arr[i-1]*nums[i-1];
        }
        int product=1;
        for(int i=n-2;i>=0;i--){
            product = product*nums[i+1];
            arr[i]=arr[i]*product;
            
        }
        return arr;
    }
}  
