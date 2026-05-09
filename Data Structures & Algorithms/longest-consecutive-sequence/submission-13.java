class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int ans=0;
        for(int num:nums){
             int count=1;
            if(set.contains(num-1)){
                continue;
            }
            else{
                int val = num+1;
                while(set.contains(val)){
                    count++;
                    val=val+1;
                }
            }
            if(count>ans){
                ans=count;
            }

        }
        return ans;
    }
}
