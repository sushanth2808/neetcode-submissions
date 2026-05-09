class Solution {
    List<Integer> combination = new ArrayList<>();
    List<List<Integer>> combinationList = new ArrayList<>();
    Set<String> duplicateSet = new HashSet<>();
    int[] countArray = new int[31];
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        findCombinations(0,nums,target);
        return combinationList;
    }

    private void findCombinations(int index, int[] nums, int target){
        if(target==0){
            combinationList.add(new ArrayList<>(combination));
        }
        if(target<0){
            return;
        }
        for(int i=index;i<nums.length;i++){
            combination.add(nums[i]);
            findCombinations(i,nums,target-nums[i]);
            combination.remove(combination.size()-1);
        }
    }
}
