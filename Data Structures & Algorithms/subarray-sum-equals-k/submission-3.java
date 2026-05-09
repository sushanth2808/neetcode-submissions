class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int sum =0;
        int res=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            int diff = sum-k;
            if(map.containsKey(diff)){
                res+=map.get(diff);
            }
            int count= map.getOrDefault(sum,0);
            map.put(sum,count+1);
        }

        return res;

        
        
    }

// -1 -2 -1 

}





