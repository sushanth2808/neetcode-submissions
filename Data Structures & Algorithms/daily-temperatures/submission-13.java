class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[n];
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()[0]<temperatures[i]){
                int[] temp = stack.pop();
                res[temp[1]]=i-temp[1];
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return res;
    }
}
