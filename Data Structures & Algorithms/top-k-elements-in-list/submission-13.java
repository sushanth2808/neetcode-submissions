class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n =nums.length;
        Map<Integer,Integer> map = new HashMap<>();

        int maxf=0;
        for(int i=0;i<n;i++){
            int f = map.getOrDefault(nums[i],0)+1;
            maxf=Math.max(maxf,f);
            map.put(nums[i],f);
        }
        
        List<Integer>[] farr = (List<Integer>[]) new ArrayList[maxf+1];
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int value = entry.getValue();
            if(farr[value]==null){
                farr[value]=new ArrayList<>();
            }
            farr[value].add(entry.getKey());
        }

        int[] res = new int[k];

        int index=0;
        for(int i=maxf;i>0 && index<k;i--){
            List<Integer> list = farr[i];
            if(list==null){continue;}
            for(int num : list){
                res[index++]=num;
                if(index==k){
                    return res;
                }
            } 
        }
        return res;
    }
}
