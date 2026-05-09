class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        int index=0;
        Stack<int[]> stack = new Stack<>();
        
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek()[0]<temperatures[i]){
                int[] arr = stack.pop();
                result[arr[1]]=i-arr[1];
            }
            stack.push(new int[]{temperatures[i],i});
        }
        return result;
       
    }
}

