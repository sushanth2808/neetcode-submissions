class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int i=0;i<numbers.length;i++){
            int sum = target-numbers[i];
            for(int j=0;j<numbers.length;j++){
                if(numbers[j]==sum){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[0];
    }
}
