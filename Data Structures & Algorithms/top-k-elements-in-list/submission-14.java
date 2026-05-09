class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n =nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(Map.Entry<Integer,Integer>  entry : map.entrySet()){
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }

        int[] res = new int[k];
        int index=0;
        while(!pq.isEmpty()){
            res[index++]=pq.poll()[0];
            if(--k==0){
                return res;
            }
        }
        return res;
    }
}
