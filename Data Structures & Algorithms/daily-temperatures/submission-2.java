class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=temperatures[i]){
                stack.pop();
                index.pop();
            }
            if(!stack.isEmpty()){
                result[i]=index.peek()-i;
            }
            else{
                result[i]=0;
            }
            stack.push(temperatures[i]);
            index.push(i);
        }
        return result;
    }
}
