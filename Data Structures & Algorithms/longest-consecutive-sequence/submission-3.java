class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int length=0;
        int maxlength=0;
        for(int i=0;i<n;i++){
            if(!set.contains(nums[i]-1)){
                int curr = nums[i];
                while(set.contains(curr)){
                    length++;
                    curr=curr+1;
                }
            }
            if(length>maxlength){
                maxlength=length;
            }
            length=0;
        }
        return maxlength;

    }
}
