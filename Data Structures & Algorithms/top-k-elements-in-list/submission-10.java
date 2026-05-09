class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n =nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<int[]> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer>  entry : map.entrySet()){
            list.add(new int[]{entry.getKey(),entry.getValue()});
        }
        Collections.sort(list,(a,b)->b[1]-a[1]);
        int[] res = new int[k];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i)[0];
            k--;
            if(k==0){
                return res;
            }
        }
        return res;
    }
}
