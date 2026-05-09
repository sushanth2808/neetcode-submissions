class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        findSubSets(0,nums.length,nums,list,res);
        res.add(new ArrayList<>());
        return res;
    }

    private void findSubSets(int index,int n, int[] nums,List<Integer> list,List<List<Integer>> res){
        if(index==n){
            return;
        }
        for(int i=index;i<n;i++){
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            findSubSets(i+1,n,nums,list,res);
            list.remove(list.size()-1);
        }
          
    }
}
