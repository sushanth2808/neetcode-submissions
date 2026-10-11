class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int freq = map.getOrDefault(nums[i],0);
            map.put(nums[i],freq+1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            q.offer(new int[]{entry.getKey(),entry.getValue()});
            if(q.size()>k){
                q.poll();
            }
        }
        int[] res = new int[k];
        int index=k-1;
        while(!q.isEmpty()){
            res[index--]=q.poll()[0];
        }
        return res;
        
    }
}
