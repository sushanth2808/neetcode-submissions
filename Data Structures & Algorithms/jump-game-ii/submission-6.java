class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int farthest=0;
        int curr=0;
        int res=0;
        for(int i=0;i<n;i++){
            if(curr>=n-1){return res;}
            farthest = Math.max(farthest,i+nums[i]);
            if(curr==i){
                res+=1;
                curr=farthest;
            }
            
        }
        return res;
    }
}
