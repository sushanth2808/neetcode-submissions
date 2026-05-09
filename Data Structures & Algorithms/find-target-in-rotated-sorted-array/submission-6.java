class Solution {
    public int search(int[] nums, int target) {
        int n =nums.length;
        int p1=0;
        int p2=n-1;
        int breakingIndex = 0;
        while(p1<=p2){
            int mid = (p1+p2)/2;
            if(nums[mid]>=nums[0] && nums[mid]>=nums[n-1]){
                p1=mid+1;
            }  
            else{
                breakingIndex=mid;
                p2=mid-1;
            }  
        }

        System.out.println(breakingIndex);
        int res = binarySearch(0,breakingIndex-1,nums,target);
        if(res!=-1){return res;}
        return binarySearch(breakingIndex,n-1,nums,target);
    }

    private int binarySearch(int p1,int p2,int[] nums,int target){
        while(p1<=p2){
            int mid = (p1+p2)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                p2=mid-1;
            }
            else{
                p1=mid+1;
            }
        }
        return -1;
    }
}
