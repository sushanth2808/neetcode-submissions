class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    boolean[] used = new boolean[6];
    public List<List<Integer>> permute(int[] nums) {
       findPermute(nums,0,nums.length);
       return res;
    }

    private void findPermute(int[] nums, int index,int n){
        if(list.size()==n){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(used[i]){continue;}
            list.add(nums[i]);
            used[i]=true;
            findPermute(nums,i,n);
            list.remove(list.size()-1);
            used[i]=false;
       } 
    }
    
}
