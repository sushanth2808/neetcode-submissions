class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            int p1 = i+1;
            int p2=n-1;
            int target = -1*nums[i];
            
            while(p1<p2){
                int sum = nums[p1]+nums[p2];
                if(sum==target){
                   res.add(new ArrayList<>(List.of(nums[i],nums[p1],nums[p2])));
                   int num = nums[p1];
                   while(p1<n && nums[p1]==num){
                        p1+=1;
                   }
                }
                else if (sum<target){
                    p1+=1;
                }
                else{
                    p2-=1;
                }

            }
        }
        return res;
    }
}
