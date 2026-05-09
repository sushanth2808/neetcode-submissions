class Solution {
    public int largestRectangleArea(int[] heights) {

        int res=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int min=heights[i];
            for(int j=i;j<heights.length;j++){
                if(heights[j]<=min){
                    min=heights[j];
                }
                res=Math.max(res,(j-i+1)*min);
            }
        }
        return res;
        
    }
}
