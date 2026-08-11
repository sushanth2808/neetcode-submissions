class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] nums = temperatures;
        int[] res = new int[nums.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for(int i=0;i<nums.length;i++){
            while(!stack.isEmpty() && stack.peek()[0]<nums[i]){
                int[] ele = stack.pop();
                res[ele[1]]=(i-ele[1]);
            }
            stack.push(new int[]{nums[i],i});
        }
        return res;
    }
}
