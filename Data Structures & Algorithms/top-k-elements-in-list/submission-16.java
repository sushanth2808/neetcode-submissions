class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[k];
        List<Integer>[] freq = new ArrayList[n+1];
        Map<Integer,Integer>  map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int key : map.keySet()){
            int value = map.get(key);
            if(freq[value]==null){
                freq[value]=new ArrayList<>();
            }
            freq[value].add(key);
        }
        int index=0;
        for(int i=n;i>=0;i--){
            if(index==k){return res;}
            if(freq[i]==null){continue;}
            List<Integer> list = freq[i];
            for(int j=0;j<list.size();j++){
                if(index==k){return res;}
                res[index++]=list.get(j);
            }
        }
        return res;
    }
}
