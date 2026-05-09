class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int product = 1;
        int zerocount = 0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                product = product*nums[i];
            }
            else{
                zerocount++;
            }
            
        }
        if(zerocount>=2){
            return result;
        }

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                result[i] = product;
            }
            else if(nums[i]!=0 && zerocount==1){
                result[i]=0;
            }
            else{
                result[i]=product/nums[i];
            }
                
            }
             return result;
        }
       
}  
