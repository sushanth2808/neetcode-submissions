class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l=0;
        int r=n-1;
        int leftMax=height[l];
        int rightMax=height[r];
        int res =0;

        while(l<=r){
            if(leftMax<=rightMax){
                leftMax=Math.max(leftMax,height[l]);
                res=res+(leftMax-height[l]);
                l++;
            }
            else{
                rightMax=Math.max(rightMax,height[r]);
                res+=rightMax-height[r];
                r--;
            }
            
        }
        return res;

        
    }
}
