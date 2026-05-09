class Solution {
    List<Integer> combination = new ArrayList<>();
    List<List<Integer>> combinationList = new ArrayList<>();
    Set<String> duplicateSet = new HashSet<>();
    int[] countArray = new int[31];
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if(target==0){
             StringBuilder str=new StringBuilder();
            for(int i=0;i<31;i++){
                str.append(countArray[i]+"#");
            }
            if(!duplicateSet.contains(str.toString())){
                combinationList.add(new ArrayList<>(combination));
                duplicateSet.add(str.toString());
            }
            return combinationList;
            
        }
        if(target<0){
            return combinationList;
        }
        for(int i=0;i<nums.length;i++){
            combination.add(nums[i]);
            countArray[nums[i]]++;
            combinationSum(nums,target-nums[i]);
            combination.remove(combination.size()-1);
            countArray[nums[i]]--;
        }
        return combinationList;
    }
}
