class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<n;i++){
            int count=1;
            int num=nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[j]==num+1){
                    count++;
                    num=nums[j];
                }
            }
            if(count>ans){
                ans=count;
            }
        }
        return ans;
    }
}
