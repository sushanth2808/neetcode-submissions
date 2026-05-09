class Solution {
    public int longestConsecutive(int[] nums) {
        int n =nums.length;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int max=0;
        for(int i=0;i<n;i++){
            int j=nums[i];
            if(set.contains(j-1)){
                continue;
            }
            int len=0;
            while(set.contains(j)){
                len++;
                j=j+1;
            }
            max=Math.max(max,len);  
        }
        return max;
    }
}
