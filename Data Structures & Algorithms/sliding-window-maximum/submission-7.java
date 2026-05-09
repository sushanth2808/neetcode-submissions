class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n =nums.length;
        int[] res = new int[n-k+1];
        int index=0;
        Deque<Integer> q = new ArrayDeque<>();
        
        int left =0;
        for(int right=0;right<n;right++){
            while(!q.isEmpty() && q.peekFirst()<nums[right]){
                q.pollFirst();
            }
            q.addFirst(nums[right]);
            if(right-left+1==k){
                System.out.println(q.peekLast());
                res[index++]=q.peekLast();
                if(nums[left]==q.peekLast()){
                    q.pollLast();
                }
                left++;

            }
        }
        return res;
    }
}
