class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        for(int i=0;i<n;i++){
            int area = 0;
            int val = heights[i];
            for(int j=i;j<n;j++){   
                if(heights[j]<val){
                    area=area-(j-i)*(val-heights[j]);
                    val=heights[j];
                }
                area=area+val;
                res = Math.max(res,area);
            }
        }
        return res;
    }
}
