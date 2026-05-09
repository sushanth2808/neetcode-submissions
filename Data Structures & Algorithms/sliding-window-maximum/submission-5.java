class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n =nums.length;
        int[] res = new int[n-k+1];
        int index=0;
        for(int i=0;i<=n-k;i++){
            int max = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++){
               max = Math.max(nums[j],max);
            }
            res[index++]=max;
        }
        return res;
    }
}
