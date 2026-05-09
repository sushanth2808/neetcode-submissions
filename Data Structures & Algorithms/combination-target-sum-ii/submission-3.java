class Solution {
    List<Integer> combination = new ArrayList<>();
    List<List<Integer>> combinationList = new ArrayList<>();
    Set<String> duplicateSet = new HashSet<>();
    int[] countArray = new int[31];
    boolean bool = false;
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        findCombinations(0,nums,target);
        return combinationList;
    }

    private void findCombinations(int index, int[] nums, int target){
        bool = false;
        for(int i=index;i<nums.length;i++){
            if(i>0 && bool && nums[i]==nums[i-1]){
                continue;
            }
            if(target-nums[i]<0){
                return;
            }
            combination.add(nums[i]);
            if(target-nums[i]==0){
                combinationList.add(new ArrayList<>(combination));
            }
            findCombinations(i+1,nums,target-nums[i]);
            combination.remove(combination.size()-1);
            bool = true;
        }
    }
}

