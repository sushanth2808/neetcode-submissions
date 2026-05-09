class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        int max = 0;
        for(int num:nums){
            set.add(num);
        }
        for(int i=0;i<n;i++){
            int length = 0;
            if(!set.contains(nums[i]-1)){
                int curr = nums[i];
                while(set.contains(curr)){
                    length++;
                    curr+=1;
                }
                if(length>max){
                    max = length;
                }
            }  
        }
        return max;
    }
}
