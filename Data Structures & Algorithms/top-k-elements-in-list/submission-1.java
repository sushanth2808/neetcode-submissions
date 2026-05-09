class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int n = nums.length;
        List<Integer>[] buckets = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            buckets[i]=new ArrayList<>();
        }

        int index =0;
        for(int key: map.keySet()){
            buckets[map.get(key)].add(key);
        }
        int[] result = new int[k];
        index =0;
        for(int i=n;i>=0;i--){
            for(int j=0;j<buckets[i].size();j++){
                result[index] = buckets[i].get(j);
                index++;
                if(index==k){
                    return result;
                }
        }
    }
    return result;
}
}
