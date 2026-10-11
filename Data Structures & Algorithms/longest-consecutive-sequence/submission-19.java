class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        } 
        int res=0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i]-1)){
                continue;
            }
            else{
                int num = nums[i];
                int count = 0;
                while(set.contains(num)){
                    count++;
                    num++;
                }
                res = Math.max(res,count);
            }
        }
         return res;
    }
   
}
