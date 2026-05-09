class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<(1<<n);i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                if(((i>>j)&1)==1){
                    list.add(nums[j]);
                }
            }
            res.add(list);
        }
        return res;
    }

    private void findSubSets(int index,int n, int[] nums,List<Integer> list,List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        if(index==n){
            return;
        }
        for(int i=index;i<n;i++){
            list.add(nums[i]); 
            findSubSets(i+1,n,nums,list,res);
            list.remove(list.size()-1);
        }
          
    }
}
