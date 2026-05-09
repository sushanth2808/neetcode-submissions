class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int res = 0;
        int p1=0;
        int p2=n-1;
        while(p1<p2){
            int area =findArea(p1,p2,heights);
            if(heights[p1]<heights[p2]){
                p1++;
            }
            else{p2--;}
            res=Math.max(area,res);
        }
        return res;
    }
    
    private int findArea(int p1,int p2,int[] arr){
        return Math.min(arr[p1],arr[p2])*(p2-p1);
    }
}
