class Solution {
    public int trap(int[] height) {
        int left =0;
        int n = height.length;
        int maxLeft=0;
        int maxRight=0;
        int result = 0;
        int right=n-1;
       while(right>left){
            if(height[right]>=height[left]){
                maxLeft = Math.max(maxLeft,height[left]);
                result+=maxLeft-height[left];
                left++;
            }
            else{
                maxRight = Math.max(maxRight,height[right]);
                result+=maxRight-height[right];
                right--;
            }
        }
        return result;
    }
}
