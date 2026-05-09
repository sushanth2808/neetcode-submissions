class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int area = Math.min(heights[i],heights[j])*(j-i);
                res=Math.max(area,res);
            }
        }
        return res;
    }
}
