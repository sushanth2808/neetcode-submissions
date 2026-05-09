class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int first = i+1;
            int last = nums.length-1;
            int sum = -1*nums[i];
            while(first<last){
                int s = nums[first]+nums[last];
                if(s<sum){
                    first++;
                }
                else if(s>sum){
                    last--;
                }
                else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[first]);
                    list.add(nums[last]);
                    res.add(list);
                    first++;
                    last--;
                     while (first < last && nums[first] == nums[first - 1]) {
                        first++;
                    }
                } 
            }
        }
        return res;
    }
}
