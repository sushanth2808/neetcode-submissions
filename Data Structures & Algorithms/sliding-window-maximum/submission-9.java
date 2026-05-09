

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n =nums.length;
        int[] res = new int[n-k+1];
        int index=0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int left=0;

        for(int right=0;right<n;right++){

            q.add(new int[]{nums[right],right});

            if(right-left+1==k){
                res[index++]=q.peek()[0];

                if(q.peek()[0]==nums[left] && left==q.peek()[1]){
                    while(!q.isEmpty() && q.peek()[1]<=left){
                        q.poll();
                    }
                }
                left++;
            }

        }
        return res;
        
    }
}