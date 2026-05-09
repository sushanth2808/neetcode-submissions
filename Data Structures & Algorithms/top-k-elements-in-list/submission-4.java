class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int n = nums.length;
        List<Integer>[] list =  new List[n+1];
             for(int i=0;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        for(int key : map.keySet()){
            list[map.get(key)].add(key);
        }
        int[] result = new int[k];
        int index=0;
for (int i = n; i >= 0 && index < k; i--) {
    for (int j = 0; j < list[i].size() && index < k; j++) {
        result[index] = list[i].get(j);
        index++;
    }
}

        return result;
    }


}
