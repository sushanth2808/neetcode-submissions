class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int max =0;
        int l=0;
        int r=n-1;
        while(l<=r){
            if(heights[l]<heights[r]){
                max = Math.max(max,(r-l)*heights[l]);
                l++;
            }
            else{
                max=Math.max(max,(r-l)*heights[r]);
                r--;
            }
        }
        return max;
    }
}
