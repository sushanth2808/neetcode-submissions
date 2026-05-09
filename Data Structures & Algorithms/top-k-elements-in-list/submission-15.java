class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n =nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Map.Entry<Integer,Integer>  entry : map.entrySet()){
            pq.add(new int[]{entry.getKey(),entry.getValue()});
            if(pq.size()>k){
                pq.poll();
            }
            
        
        }

        int[] res = new int[k];
        int index=0;
        while(!pq.isEmpty()){
            res[index++]=pq.poll()[0];
        }
        return res;
    }
}
