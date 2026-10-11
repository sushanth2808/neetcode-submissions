class Solution {
    public int maxArea(int[] heights) {
        int p1 = 0;
        int p2 = heights.length-1;
        int res = 0;
        while(p1<p2){
            int min = Math.min(heights[p1],heights[p2]);
            res = Math.max((p2-p1)*min,res);
            if(heights[p1]==min){
                p1++;
            }
            else{
                p2--;
            }
        }
        return res;
    }
}
