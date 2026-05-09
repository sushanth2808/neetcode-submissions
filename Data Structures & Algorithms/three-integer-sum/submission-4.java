class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n =nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i-1]==nums[i]){
                continue;
            }
            find(i+1,n-1,-1*(nums[i]),res,nums);
        }
        return res; 
    }

    private void find(int p1,int p2,int target,List<List<Integer>> res,int[] nums){
        int start=p1;
        while(p1<p2){
            if(p1>start && nums[p1]==nums[p1-1]){
                p1++;
                continue;
            }
            if(nums[p1]+nums[p2]<target){
                p1++;
            }
            else if(nums[p1]+nums[p2]>target){
                p2--;
            }
            else{
                res.add(Arrays.asList(-1*target,nums[p1],nums[p2]));
                p1++;
                p2--;
            }
        }
    }

    
}
