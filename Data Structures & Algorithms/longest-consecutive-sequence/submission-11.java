class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans=0;
        int i=0;
       while(i<n){
            int count=1;
            int num=nums[i];
            int j;
            for(j=i+1;j<n;j++){
                if(nums[j]==num+1){
                    count++;
                    num=nums[j];
                    i++;
                }
                else if(nums[j]==num){
                    continue;
                }
                else{
                   
                    break;
                }
            }
            if(count>ans){
                ans=count;
            }
            i=j;
        }
        return ans;
    }
}
