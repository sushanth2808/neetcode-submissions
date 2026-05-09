class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        if(n<k){return new int[0];}

        int[] res = new int[n-k+1];
        int index=0;
        int l=0;
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<n;i++){

            p.offer(new int[]{nums[i],i});

            if(i+1>=k){
                while(p.peek()[1]<l){
                    p.poll();
                }
                res[index++] = p.peek()[0];
                l++;
            }
        }
        return res;
    }
}
