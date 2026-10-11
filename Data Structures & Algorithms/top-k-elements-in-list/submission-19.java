class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int freq = map.getOrDefault(nums[i],0);
            map.put(nums[i],freq+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(bucket[val]==null){
                bucket[val]=new ArrayList<>();
            }
            bucket[val].add(entry.getKey());
        }
        int[] res = new int[k];
        int index =0;
        for(int i=bucket.length-1;i>0;i--){
            if(k==0){return res;}
            if(bucket[i]==null){continue;}
            for(int j=0;j<bucket[i].size();j++){
                if(k==0){return res;}
                res[index++]=bucket[i].get(j);
                k--;
            }
        }
        return res;
    }
}
