class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res=Integer.MIN_VALUE;
        Stack<int[]> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()){
                stack.push(new int[]{heights[i],i});
            }
            else{
                int index = i;
                while(!stack.isEmpty() && heights[i]<=stack.peek()[0]){
                    int[] arr= stack.pop();
                    res=Math.max(res,(i-arr[1])*arr[0]);
                    index=arr[1];
                }
                stack.push(new int[]{heights[i],index});
            }
        }
        
        while(!stack.isEmpty()){
            int[] arr = stack.pop();
            res=Math.max(res,(n-arr[1])*arr[0]);
        }
        return res;
        
    }
}
