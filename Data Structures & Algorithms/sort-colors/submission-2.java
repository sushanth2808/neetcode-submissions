class Solution {
    public void sortColors(int[] nums) {
        int p1=0;
        int p2=0;
        int p3=nums.length-1;
        int n =nums.length;

        while(p2<=p3){
            while(p1<n && nums[p1]==0){
                p1++;
                p2++;      
            }
            while(p3>=0 && nums[p3]==2){
                p3--;
            }
            if(p2<n && nums[p2]==1){
                p2++;
            }
            else{
                if(p2<n && nums[p2]==0){
                    nums[p2]=nums[p1];
                    nums[p1]=0;
                    p1++;
                }
                else{
                    if(p2<n && p3>=0 ){
                                            nums[p2]=nums[p3];
                    nums[p3]=2;
                    p3--;
                    }
                }
            }
        }
    }
}