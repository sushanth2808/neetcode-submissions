class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int n = nums.length;
        int[] farr = new int[n];
        int[] barr = new int[n];
        farr[0]=1;
        barr[n-1]=1;
        int[] result = new int[n];
        for(int i=1;i<n;i++){
            farr[i] = farr[i-1]*nums[i-1];
            barr[n-i-1] = barr[n-i]*nums[n-i];
        }
        for(int i=0;i<n;i++){
            result[i]=farr[i]*barr[i];
        }
        return result;
    }
}  
