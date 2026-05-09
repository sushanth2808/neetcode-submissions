class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] temp = temperatures;
        int n = temp.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()[0]<temp[i]){
                int[] pop = stack.pop();
                res[pop[1]]=i-pop[1];
            }
            stack.push(new int[]{temp[i],i});
        }
        return res;
    }
}
