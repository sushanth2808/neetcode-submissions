class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        int res = 0;
        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            int count=0;
            if(!set.contains(num-1)){
                while(set.contains(num)){
                    count++;
                    num=num+1;
                }
                res = Math.max(res,count);
            }
        }

        return res;
    }
}
