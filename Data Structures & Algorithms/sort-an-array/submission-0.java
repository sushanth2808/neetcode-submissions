class Solution {
    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            pq.offer(nums[i]);
        }

        for(int i=0;i<n;i++){
            nums[i]=pq.poll();
        }

        return nums;
        
    }
}