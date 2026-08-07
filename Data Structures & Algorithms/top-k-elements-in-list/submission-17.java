class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        
        Map<Integer,Integer>  map = new HashMap<>();
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key: map.keySet()){
            p.add(new int[]{key,map.get(key)});
            if(p.size()>k){
                p.poll();
            }
        }  
        int index=0;
        while(!p.isEmpty()){
           res[index++]=p.poll()[0]; 
        }
        return res;
    }
}
