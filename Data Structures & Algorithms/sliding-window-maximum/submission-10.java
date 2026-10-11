class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        int  n = nums.length;
        int left = 0;
        int[] res = new int[n-k+1];
        for(int right=0;right<nums.length;right++){
            pq.offer(new int[]{nums[right],right});
            if(right-left+1==k){
                while(pq.peek()[1]<left){
                    pq.poll();
                }
                res[left]=pq.peek()[0];
                left++;
            }
        } 
        return res;
    }
}
