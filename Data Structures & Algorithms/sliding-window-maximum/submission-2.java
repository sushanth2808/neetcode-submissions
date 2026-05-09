class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        if(n<k){return new int[0];}

        int[] res = new int[n-k+1];
        int left=0;
        int index=0;
        for(int i=0;i<k;i++){
            if(nums[i]>=max){
                left=i;
                max=nums[i];
            }
            res[index]=max;
        }
        index++;
        for(int i=k;i<n;i++){
            if(nums[i]>=max){
                max=nums[i];
                left=i;
            }
            if(left>=i-k+1){
                res[index]=nums[left];
            }
            else{
                
                int p1=left+1;
                max=nums[p1];
                while(p1<=i){
                    if(nums[p1]>=max){
                        left=p1;
                        System.out.println(left);
                        max=nums[p1];
                        System.out.println(max);
                    }
                    p1++;
                }
                res[index]=max;
            }
            index++;
        }
        return res;

    }
}
