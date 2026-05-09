class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int n=nums.length;
        if(n<k){return new int[0];}

        int[] res = new int[n-k+1];
        int index=0;
        Deque<Integer> q = new LinkedList<>();
        int l=0,r=0;
        while(r<n){
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]){
                q.removeLast();
            }
            q.add(r);
            if(l>q.getFirst()){
                q.removeFirst();
            }
            if(r+1>=k){
                res[index++]=nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return res;
    }
}
