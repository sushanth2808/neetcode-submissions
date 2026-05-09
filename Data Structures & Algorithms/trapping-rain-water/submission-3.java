class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res =0;
        for(int i=0;i<n;i++){
            int maxleft=0;
            int maxright=0;
            for(int j=0;j<n;j++){
                if(j<=i){
                    maxleft=Math.max(maxleft,height[j]);
                }
                if(j>=i){
                    maxright=Math.max(maxright,height[j]);
                }
            }
            res+=Math.min(maxleft,maxright)-height[i];
        }
        return res;
    }
}
