class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        findSubSets(0,n,nums,list,res);
        return res;
    }

    private void findSubSets(int index,int n, int[] nums,List<Integer> list,List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        if(index==n){
            return;
        }
        for(int i=index;i<n;i++){
            if(i>index && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]); 
            findSubSets(i+1,n,nums,list,res);
            list.remove(list.size()-1);
        }
          
    }
}

