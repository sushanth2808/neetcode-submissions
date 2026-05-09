class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int[] res = new int[n];
        arr[n-1]=1;
        for(int i=n-2;i>=0;i--){
            arr[i]=arr[i+1]*nums[i+1];
        }
        int prod = 1;
        for(int j=0;j<n;j++){
            res[j]=arr[j]*prod;
            prod=prod*nums[j];
        }
        return res;
    }
}  
