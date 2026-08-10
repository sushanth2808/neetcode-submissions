class Solution {
    public int maxArea(int[] heights) {
        int p2 = heights.length-1;
        int p1=0;
        int res=0;

        while(p1<p2){
            int min = Math.min(heights[p1],heights[p2]);
            int area = (p2-p1)*min;
            res=Math.max(res,area);
            if(min==heights[p1]){
                p1++;
            }
            else{
                p2--;
            }
        }
        return res;
    }
}
