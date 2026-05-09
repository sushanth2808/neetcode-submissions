class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int index=0;
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i==0 || (i!=0 && nums[i]!=nums[i-1])){
                int target = nums[i];
                findTarget(nums,list,i);
            }
        }
        return list;
    }

    private void findTarget(int[] nums,List<List<Integer>> list,int index){
        int p1 =index+1;
        int n =nums.length;
        int p2= n-1;
        int target=-1*nums[index];
        while(p1<p2){
            int sum = nums[p1]+nums[p2];
            if(sum==target){
                list.add(List.of(nums[p1],nums[p2],nums[index]));
                p1++;
                while(p1<n && nums[p1]==nums[p1-1]){
                    p1++;
                }
                p2--;
                while(p2>index && nums[p2]==nums[p2+1]){
                    p2--;
                }
            }
            else if(sum<target){
                p1++;
            }
            else{
                p2--;
            }
        }
    }
}
