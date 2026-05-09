class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n-1;
        int maxWater = 0;
        while(left<right){
            int water = findwater(left,right,heights);
            if(water>maxWater){
                maxWater = water;
            }
            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxWater;
    }
    private int findwater(int left, int right,int [] heights){
        return (right-left)*(Math.min(heights[left],heights[right]));
    }
}